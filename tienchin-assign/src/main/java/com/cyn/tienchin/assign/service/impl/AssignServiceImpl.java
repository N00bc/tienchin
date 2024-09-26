package com.cyn.tienchin.assign.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.assign.domain.Assign;
import com.cyn.tienchin.assign.mapper.AssignMapper;
import com.cyn.tienchin.assign.service.IAssignService;
import com.cyn.tienchin.common.constant.TienChinConstants;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 线索 商机明细表 服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@Service
@Transactional
public class AssignServiceImpl extends ServiceImpl<AssignMapper, Assign> implements IAssignService {

    /**
     * 增加分派记录
     *
     * @param assign
     * @return
     */
    @Override
    public AjaxResult addAssign(Assign assign) {
        try {
            // 1.需要先将当前assign中 assign.id相同数据的latest值置为0
            LambdaUpdateWrapper<Assign> updateWrapper = Wrappers.<Assign>lambdaUpdate()
                    .eq(Assign::getAssignId, assign.getAssignId())
                    .set(Assign::getLatest, TienChinConstants.IS_NOT_LATEST);
            update(updateWrapper);
            // 2.执行插入操作
            save(assign);
            return AjaxResult.success("添加分派记录成功");
        } catch (Exception e) {
            throw new RuntimeException("添加分派记录异常");
        }
    }
}
