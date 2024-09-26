package com.cyn.tienchin.common.constant;

/**
 * @author Godc
 * @description: 常量
 * @date 2023/7/08/0008 0:36
 */
public class TienChinConstants {
    /**
     * 线索
     */
    public static final Integer CLUE_TYPE = 1;
    /**
     * 商机
     */
    public static final Integer BUSINESS_TYPE = 2;

    /**
     * 已分配
     */
    public static final Integer CLUE_ALLOCATE = 1;
    /**
     * 跟进中
     */
    public static final Integer CLUE_FOLLOWING = 2;
    /**
     * 已回收
     */
    public static final Integer CLUE_RECOVER = 3;
    /**
     * 伪线索
     */
    public static final Integer CLUE_INVALIDATE = 4;

    /**
     * 已分配
     */
    public static final Integer BUSINESS_ALLOCATE = 1;
    /**
     * 跟进中
     */
    public static final Integer BUSINESS_FOLLOWING = 2;
    /**
     * 已回收
     */
    public static final Integer BUSINESS_RECOVER = 3;
    /**
     * 最新数据
     */
    public static final Integer IS_LATEST = 1;
    /**
     * 非最新数据
     */
    public static final Integer IS_NOT_LATEST = 0;

    /**
     * 默认转为商机后一手处理人
     */
    public static final String ADMIN_USERNAME = "admin";
    /**
     * 默认处理人id
     */
    public static Long ADMIN_Id = 1L;
    /**
     * 默认处理人部门Id
     */
    public static Long ADMIN_DEPT_ID = 103L;
    /**
     * admin的id
     */
    public static final Integer ADMIN_ID = 1;
    /**
     * contract.status:合同待审核
     */
    public static final Integer WAITING_APPROVE = 1;

    /**
     * contract.status:合同通过审核
     */
    public static final Integer IS_APPROVE = 2;
    /**
     * contract.status:审核失败
     */
    public static final Integer REJECT = 3;
    /**
     * xml的唯一id
     */
    public static final String CONTRACT_PROCESS_DEFINITION_ID = "tienchin_contract_approve";
}
