package com.cyn.tienchin.clue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.clue.domain.Assign;
import com.cyn.tienchin.clue.mapper.AssignMapper;
import com.cyn.tienchin.clue.service.IAssignService;
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

}
