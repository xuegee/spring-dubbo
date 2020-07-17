package com.dubbo.constant;

public enum RetCode {

    SUCCESS("成功", "0000"),
    FAILURE("失败", "0001"),
    PARAMERROR("参数错误", "0002"),
    UNLOGIN("未登录", "0003"),
    UNAUTH("未授权", "00004"),
    ERROR("异常", "00005");

    private String name;
    private String code;

    RetCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }


    public String getCode() {
        return code;
    }
}
