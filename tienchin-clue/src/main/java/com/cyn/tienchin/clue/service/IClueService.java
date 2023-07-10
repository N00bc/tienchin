package com.cyn.tienchin.clue.service;

import com.cyn.tienchin.clue.domain.Clue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.tienchin.clue.domain.vo.ClueDetails;
import com.cyn.tienchin.clue.domain.vo.ClueSummary;
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

    /**
     * 根据线索Id获取线索信息
     * @param clueId
     * @return
     */
    AjaxResult getClueDetailsByClueId(Long clueId);

    /**
     * 更新跟进西南西
     * @param clueDetails
     * @return
     */
    AjaxResult updateClueFollow(ClueDetails clueDetails);

    /**
     * 更新 `无效线索` 信息
     * @param clueDetails
     * @return
     */
    AjaxResult updateInvalidateClueFollow(ClueDetails clueDetails);

    /**
     * 返回clueSummary对象
     * @param clueId
     * @return
     */
    AjaxResult getClueSummary(Integer clueId);
}
