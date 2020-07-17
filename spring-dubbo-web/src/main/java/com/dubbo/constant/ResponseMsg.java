package com.dubbo.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "响应数据", value = "响应类")
public class ResponseMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("响应码(0000:成功，0001:失败)")
    private String retCode;
    @ApiModelProperty("错误信息")
    private String errorDesc;

    @ApiModelProperty("responseBody,自定义返回对象")
    private T responseBody;

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String retDesc) {
        this.errorDesc = retDesc;
    }

    public ResponseMsg() {

    }

    public ResponseMsg(String retCode, String errorDesc) {
        this.retCode = retCode;
        this.errorDesc = errorDesc;
    }

    public ResponseMsg(String retCode, String retDesc, T responseBody) {
        this.retCode = retCode;
        this.errorDesc = errorDesc;
        this.responseBody = responseBody;
    }

    public static ResponseMsg getSuccessResponseMsg(String retDesc) {
        return new ResponseMsg(RetCode.SUCCESS.getCode(), retDesc);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[retCode=");
        builder.append(this.getRetCode());
        builder.append(", errorDesc=");
        builder.append(this.getErrorDesc());
        builder.append("]");
        builder.append("   Body [");
        if (responseBody != null) {
            builder.append(responseBody.toString());
        }
        builder.append("]");
        return builder.toString();
    }


}
