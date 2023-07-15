package com.cyn.tienchin.common.core.domain;

/**
 * @author Godc
 * @description:
 * @date 2023/7/15/0015 21:19
 */
public class UploadFileResponse {
    /**
     * 文件名
     */
    private String name;
    /**
     * 浏览路径
     */
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
