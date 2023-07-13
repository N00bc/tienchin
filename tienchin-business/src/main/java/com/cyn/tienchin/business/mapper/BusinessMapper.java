package com.cyn.tienchin.business.mapper;

import com.cyn.tienchin.business.domain.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.business.domain.BusinessSummary;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
public interface BusinessMapper extends BaseMapper<Business> {

    /**
     * 根据条件查找商机摘要
     * @return
     */
    List<BusinessSummary> selectBusinessSummaryList();

}
