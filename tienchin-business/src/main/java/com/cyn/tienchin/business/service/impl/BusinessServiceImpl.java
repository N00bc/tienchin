package com.cyn.tienchin.business.service.impl;

import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.mapper.BusinessMapper;
import com.cyn.tienchin.business.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

}
