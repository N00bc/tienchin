package com.cyn.tienchin.clue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.clue.domain.Assign;
import com.cyn.tienchin.clue.domain.Clue;
import com.cyn.tienchin.clue.domain.ClueSummary;
import com.cyn.tienchin.clue.mapper.ClueMapper;
import com.cyn.tienchin.clue.service.IAssignService;
import com.cyn.tienchin.clue.service.IClueService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.utils.SecurityUtils;
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
}