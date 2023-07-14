package com.cyn.tienchin.web.controller.tienchin.clue;

import com.cyn.tienchin.follow.service.IFollowRecordService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@RestController
@RequestMapping("/tienchin/clue/follow/record")
public class FollowRecordController {

    @Autowired
    private IFollowRecordService followRecordService;

    /**
     * 根据线索Id获取
     * @param clueId
     * @return
     */
    @PreAuthorize("hasAnyPermissions('tienchin:clue:follow','tienchin:clue:view')")
    @GetMapping("/{clueId}")
    public AjaxResult getFollowRecordByClueId(@PathVariable("clueId") Integer clueId) {
        return followRecordService.getFollowRecordByClueId(clueId);
    }

}
