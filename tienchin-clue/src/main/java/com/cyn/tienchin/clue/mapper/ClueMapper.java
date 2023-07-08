package com.cyn.tienchin.clue.mapper;

import com.cyn.tienchin.clue.domain.Clue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.tienchin.clue.domain.ClueSummary;

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
}
