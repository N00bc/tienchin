package com.cyn.tienchin.business.mapper;

import com.cyn.tienchin.business.domain.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.business.domain.BusinessVo;
import org.apache.ibatis.annotations.Param;

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
     * @param businessVo
     */
    List<BusinessSummary> selectBusinessSummaryList(@Param("vo") BusinessVo businessVo);

}
