package com.cyn.tienchin.clue.service;

import com.cyn.tienchin.clue.domain.Clue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.clue.domain.ClueSummary;
import com.cyn.tienchin.common.core.domain.AjaxResult;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
public interface IClueService extends IService<Clue> {

    /**
     * 新增线索
     *
     * @param clue
     * @return
     */
    AjaxResult insertClue(Clue clue);

    /**
     * 查询线索概要
     * @return
     */
    List<ClueSummary> selectClueSummaryList();

}
