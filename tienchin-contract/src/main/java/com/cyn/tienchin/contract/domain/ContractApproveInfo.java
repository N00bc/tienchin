package com.cyn.tienchin.contract.domain;

/**
 * @author Godc
 * @description:
 * @date 2023/7/19/0019 15:01
 */
public class ContractApproveInfo {
    /**
     * 任务id
     */
    private String taskId;
    /**
     * 同意或拒绝
     */
    private Boolean approve;
    /**
     * 拒绝/同意理由
     */
    private String reason;
    /**
     * 合同id
     */
    private Integer contractId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "ContractApproveInfo{" +
                "taskId='" + taskId + '\'' +
                ", approve=" + approve +
                ", reason='" + reason + '\'' +
                ", contractId=" + contractId +
                '}';
    }
}
