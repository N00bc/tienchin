package com.cyn.tienchin.channel.domain.vo;

import com.cyn.tienchin.common.core.domain.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Godc
 * @description:
 * @date 2023/7/03/0003 1:06
 */
public class ChannelVo extends BaseEntity {
    /**
     * 渠道id
     */
    private Integer channelId;

    /**
     * 渠道名
     */
    @NotBlank(message = "{channel.name.notnull}")
    private String channelName;

    /**
     * 渠道启用状态 0禁用 1启用
     */
    @NotNull(message = "{channel.status.notnull}")
    @Max(value = 1, message = "{channel.status.invalid}")
    @Min(value = 0, message = "{channel.status.invalid}")
    private Byte status;


    /**
     * 渠道类型：1线上渠道 2线下渠道
     */
    @NotNull(message = "{channel.type.notnull}")
    @Max(value = 2, message = "{channel.type.invalid}")
    @Min(value = 1, message = "{channel.type.invalid}")
    private Integer type;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ChannelVo{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
