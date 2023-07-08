package com.cyn.tienchin.clue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyn.tienchin.clue.domain.FollowRecord;
import com.cyn.tienchin.clue.mapper.FollowRecordMapper;
import com.cyn.tienchin.clue.service.IFollowRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class FollowRecordServiceImpl extends ServiceImpl<FollowRecordMapper, FollowRecord> implements IFollowRecordService {

}
