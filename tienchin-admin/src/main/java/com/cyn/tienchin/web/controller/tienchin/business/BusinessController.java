package com.cyn.tienchin.web.controller.tienchin.business;

import com.cyn.tienchin.business.domain.Business;
import com.cyn.tienchin.business.domain.BusinessSummary;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.common.annotation.Log;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-11
 */
@RestController
@RequestMapping("/tienchin/business")
public class BusinessController extends BaseController {
    @Autowired
    private IBusinessService businessService;

    @PreAuthorize("hasPermission('tienchin:business:list')")
    @GetMapping("/list")
    public TableDataInfo list() {
        startPage();
        List<BusinessSummary> list = businessService.selectBusinessSummaryList();
        return getDataTable(list);
    }

    /**
     * 添加商机:
     *  意愿及其强烈的客户可以直接新增
     * @param business
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:business:add')")
    @Log(title = "商机管理",businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Business business){
        return businessService.addBusiness(business);
    }
}
