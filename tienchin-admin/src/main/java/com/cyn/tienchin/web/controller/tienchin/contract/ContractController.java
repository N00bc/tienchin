package com.cyn.tienchin.web.controller.tienchin.contract;

import com.cyn.minio.autoconfigure.service.IFileStorageService;
import com.cyn.tienchin.business.service.IBusinessService;
import com.cyn.tienchin.common.core.controller.BaseController;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.domain.UploadFileResponse;
import com.cyn.tienchin.common.core.page.TableDataInfo;
import com.cyn.tienchin.contract.domain.Contract;
import com.cyn.tienchin.contract.domain.ContractApproveInfo;
import com.cyn.tienchin.contract.domain.ContractSummary;
import com.cyn.tienchin.contract.service.IContractService;
import com.cyn.tienchin.course.service.ICourseService;
import com.cyn.tienchin.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 合同实体 前端控制器
 * </p>
 *
 * @author cyn
 * @since 2023-07-15
 */
@RestController
@RequestMapping("/tienchin/contract")
public class ContractController extends BaseController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IFileStorageService minioService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IBusinessService businessService;

    /**
     * 根据`type`查找对应课程
     *
     * @param type
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @GetMapping("/course/{type}")
    public AjaxResult listCourseByCourseType(@PathVariable("type") Integer type) {
        return courseService.selectCourseByCourseType(type);
    }

    /**
     * 服务器上传文件接口
     *
     * @param multipartFile 合同
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @PostMapping("/upload")
    public AjaxResult uploadContractFile(@RequestParam("file") MultipartFile multipartFile) {
        try {
            String viewPath = minioService.uploadFile(null, multipartFile.getOriginalFilename(), multipartFile.getInputStream());
            UploadFileResponse uploadFileResponse = new UploadFileResponse();
            uploadFileResponse.setName(multipartFile.getOriginalFilename());
            uploadFileResponse.setUrl(viewPath);
            return AjaxResult.success(uploadFileResponse);
        } catch (IOException e) {
            throw new RuntimeException("文件上传错误");
        }
    }

    /**
     * 服务器文件删除接口
     *
     * @param fullPath
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @DeleteMapping("/remove_contract")
    public AjaxResult deleteContractFile(@RequestBody String fullPath) {
        try {
            minioService.delete(fullPath);
            return AjaxResult.success("删除文件成功");
        } catch (Exception e) {
            return AjaxResult.error("删除文件失败");
        }
    }

    /**
     * 新增合同
     *
     * @param contract
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:constract:add')")
    @PostMapping
    public AjaxResult addContract(@RequestBody Contract contract) {
        return contractService.addContract(contract);
    }

    /**
     * 顶部搜索栏:根据拥有人查找
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:query')")
    @GetMapping("/owner")
    public AjaxResult getOwnerList() {
        return sysUserService.getOwnerList();
    }

    /**
     * 根据部门id查询部门员工信息
     *
     * @param deptId
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @GetMapping("/users/{deptId}")
    public AjaxResult getUserListByDeptId(@PathVariable("deptId") Long deptId) {
        return sysUserService.getUserByDeptId(deptId);
    }

    /**
     * 根据客户手机号查找客户姓名
     *
     * @param phoneNumber
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:add')")
    @GetMapping("/customer/{phoneNumber}")
    public AjaxResult getCustomerNameByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return businessService.getCustomerNameByPhoneNumber(phoneNumber);
    }

    /**
     * 查询当前用户待审批的任务
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:list')")
    @GetMapping("/unapprove")
    public TableDataInfo getUnapproveTask() {
        startPage();
        List<ContractSummary> result = contractService.getUnapproveTask();
        return getDataTable(result);
    }
    /**
     * 查询当前用户已提交待审批任务
     *
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:list')")
    @GetMapping("/committedTask")
    public TableDataInfo committedTask() {
        startPage();
        List<ContractSummary> result = contractService.getCommittedTask();
        return getDataTable(result);
    }

    /**
     * 审批任务
     * @param contractApproveInfo
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:approve')")
    @PostMapping("/approve")
    public AjaxResult approveOrReject(@RequestBody ContractApproveInfo contractApproveInfo){
        return contractService.approveOrReject(contractApproveInfo);
    }

    /**
     * 根据合同id查看合同
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:view')")
    @GetMapping("/view/{contractId}")
    public AjaxResult getContractBytId(@PathVariable("contractId") Integer id) {
        return contractService.getContractBytId(id);
    }

    /**
     * @param year  年
     * @param month 月
     * @param day   日
     * @param name  文件名
     */
    @PreAuthorize("hasPermission('tienchin:contract:view')")
    @GetMapping("/pdf/{year}/{month}/{day}/{name}")
    public AjaxResult showContractPdf(@PathVariable("year") String year,
                                      @PathVariable("month") String month,
                                      @PathVariable("day") String day,
                                      @PathVariable("name") String name) {
        String fileName = year + SEGMENT + month + SEGMENT + day + SEGMENT + name;
        byte[] bytes = minioService.downLoadFileByName(fileName, BUCKET_NAME);
        return contractService.transWord2Pdf(bytes, fileName);
    }

    public static final String SEGMENT = "/";
    public static final String BUCKET_NAME = "contract";
}
