package com.cyn.tienchin.web.controller.tienchin.clue;

import com.cyn.tienchin.clue.domain.Assign;
import com.cyn.tienchin.clue.service.IAssignService;
import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.enums.BusinessType;
import com.cyn.tienchin.common.validator.AddGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 线索 商机明细表 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-07
 */
@RestController
@RequestMapping("/tienchin/assign")
public class AssignController {
    @Autowired
    private IAssignService assignService;

    /**
     * 新增活动
     *
     * @param assign
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:assign:add')")
    @Log(title = "分派管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated(AddGroup.class) @RequestBody Assign assign) {
        return assignService.addAssign(assign);
    }

}
