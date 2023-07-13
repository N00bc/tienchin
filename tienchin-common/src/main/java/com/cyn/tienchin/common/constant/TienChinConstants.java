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

    public static final Integer IS_LATEST = 1;
    public static final Integer IS_NOT_LATEST = 2;

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
    private static final Integer ADMIN_ID = 1;
}
