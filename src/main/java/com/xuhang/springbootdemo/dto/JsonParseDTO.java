package com.xuhang.springbootdemo.dto;

/**
 * @author xuhang
 * @date 2019/8/12 16:22
 */
public class JsonParseDTO {
    private String code;
    private String name;
    private Integer id;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
