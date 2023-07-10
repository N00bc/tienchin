package com.cyn.tienchin.clue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.clue.domain.Assign;
import com.cyn.tienchin.clue.domain.Clue;
import com.cyn.tienchin.clue.domain.FollowRecord;
import com.cyn.tienchin.clue.domain.vo.ClueDetails;
import com.cyn.tienchin.clue.domain.vo.ClueSummary;
import com.cyn.tienchin.clue.mapper.ClueMapper;
import com.cyn.tienchin.clue.service.IAssignService;
import com.cyn.tienchin.clue.service.IClueService;
import com.cyn.tienchin.clue.service.IFollowRecordService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@Service
@Transactional
public class ClueServiceImpl extends ServiceImpl<ClueMapper, Clue> implements IClueService {
    @Autowired
    private ClueMapper clueMapper;
    @Autowired
    private IAssignService assignService;
    @Autowired
    private IFollowRecordService followRecordService;

    /**
     * 新增线索
     *
     * @param clue
     * @return
     */
    @Override
    public AjaxResult insertClue(Clue clue) {
        /*
        1.查看当前线索用户信息是否已存在
            若存在,说明当前用户存在,则需要返回异常
            1.1若不存在,则录入当前用户信息.
            1.2在tienchin_assign表中插入信息

         */
        LambdaQueryWrapper<Clue> lambdaQueryWrapper = Wrappers.<Clue>lambdaQuery().eq(Clue::getPhoneNumber, clue.getPhoneNumber());
        Clue one = getOne(lambdaQueryWrapper);
        if (one != null) {
            return AjaxResult.error("当前用户信息已存在");
        }
        try {
            save(clue);
            Assign assign = new Assign();
            assign.setAssignId(clue.getClueId());
            assign.setType(TienChinConstants.CLUE_TYPE);
            assign.setUserId(SecurityUtils.getUserId());
            assign.setDeptId(SecurityUtils.getDeptId());
            assign.setUserName(SecurityUtils.getUsername());
            assignService.save(assign);
            return AjaxResult.success("线索录入成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("线索录入失败");
        }
    }

    /**
     * 查询线索概要
     *
     * @return
     */
    @Override
    public List<ClueSummary> selectClueSummaryList() {
        List<ClueSummary> clueSummaries = clueMapper.selectClueSummaryList();
        return clueSummaries;
    }

    /**
     * 根据线索Id获取线索信息
     *
     * @param clueId
     * @return
     */
    @Override
    public AjaxResult getClueDetailsByClueId(Long clueId) {
        ClueDetails clueDetails = clueMapper.getClueDetailsByClueId(clueId);
        return AjaxResult.success(clueDetails);
    }

    /**
     * 更新跟进西南西
     *
     * @param clueDetails
     * @return
     */
    @Override
    public AjaxResult updateClueFollow(ClueDetails clueDetails) {
        /**
         * 1.更新tienchin_clue表
         * 2.更新tienchin_clue_follow表
         */
        try {
            Clue clue = new Clue();
            BeanUtils.copyProperties(clueDetails, clue);
            updateById(clue);
            FollowRecord followRecord = getFollowRecordByClueDetails(clueDetails);
            followRecordService.save(followRecord);
            return AjaxResult.success("线索跟进成功");
        } catch (BeansException e) {
            return AjaxResult.error("线索跟进失败");
        }
    }

    /**
     * 根据ClueDetails得到FollowRecord
     * @param clueDetails
     * @return
     */
    private FollowRecord getFollowRecordByClueDetails(ClueDetails clueDetails) {
        FollowRecord followRecord = new FollowRecord();
        followRecord.setType(TienChinConstants.CLUE_TYPE);
        followRecord.setAssignId(clueDetails.getClueId());
        followRecord.setInfo(clueDetails.getRecord());
        return followRecord;
    }
}
