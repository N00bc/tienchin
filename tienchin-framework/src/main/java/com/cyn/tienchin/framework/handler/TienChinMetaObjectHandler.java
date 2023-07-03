package com.cyn.tienchin.framework.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cyn.tienchin.common.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Godc
 * @description: 自动填充
 * @date 2023/7/03/0003 1:23
 */
@Component
public class TienChinMetaObjectHandler implements MetaObjectHandler {
    private static final Logger logger = LoggerFactory.getLogger(TienChinMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("自动添加创建时间和创建人");
        // 自动添加创建时间
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        // 自动添加创建人
        this.strictInsertFill(metaObject, "createBy", SecurityUtils::getUsername, String.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("自动添加更新时间和更新人");
        // 自动添加更新时间
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        // 自动添加更新人
        this.strictUpdateFill(metaObject, "updateBy", SecurityUtils::getUsername, String.class);
    }
}
