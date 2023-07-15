package com.cyn.tienchin.web.controller.tienchin.contract;

import com.cyn.minio.autoconfigure.service.IFileStorageService;
import com.cyn.tienchin.common.core.domain.AjaxResult;
import com.cyn.tienchin.common.core.domain.UploadFileResponse;
import com.cyn.tienchin.contract.domain.Contract;
import com.cyn.tienchin.contract.service.IContractService;
import com.cyn.tienchin.course.service.ICourseService;
import com.cyn.tienchin.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
public class ContractController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IFileStorageService minioService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private ISysUserService sysUserService;

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
     * @return
     */
    @PreAuthorize("hasPermission('tienchin:contract:list')")
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
    @PreAuthorize("hasPermission('tienchin:contract:assign')")
    @GetMapping("/users/{deptId}")
    public AjaxResult getUserListByDeptId(@PathVariable("deptId") Long deptId) {
        return sysUserService.getUserByDeptId(deptId);
    }
}
