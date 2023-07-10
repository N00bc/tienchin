package com.cyn.tienchin.clue.mapper;

import com.cyn.tienchin.clue.domain.Clue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.clue.domain.vo.ClueDetails;
import com.cyn.tienchin.clue.domain.vo.ClueSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
public interface ClueMapper extends BaseMapper<Clue> {

    /**
     * 查找线索摘要信息
     * @return
     */
    List<ClueSummary> selectClueSummaryList();

    /**
     * 根据线索id获取线索详情
     * @param clueId
     * @return
     */
    ClueDetails getClueDetailsByClueId(@Param("clueId") Long clueId);

    /**
     * 根据 线索id获取线索概要
     * @param clueId
     * @return
     */
    ClueSummary getClueSummaryByClueId(Integer clueId);
}
