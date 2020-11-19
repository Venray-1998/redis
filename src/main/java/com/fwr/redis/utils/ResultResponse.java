package com.fwr.redis.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * @author fwr
 * @date 2020-11-18
 */
@Data
public class ResultResponse<T> implements Serializable {

    Integer code;

    String message;

    T data;

    public ResultResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功反序列化必须要默认构造器，getter和setter
     */
    public ResultResponse() {

    }

    /**
     * .请求应答成功
     */
    public static <T> ResultResponse<T> toSuccessResult(T data) {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        return new ResultResponse<T>(responseCode.getCode(), responseCode.getMessage(), data);
    }

    /**
     * .请求应答成功
     */
    public static <T> ResultResponse<T> toSuccessResult() {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        return new ResultResponse<T>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    /**
     * .请求应答失败
     */
    public static <T> ResultResponse<T> toFailureResult(String errMsg) {
        ResponseCode responseCode = ResponseCode.FAILURE;
        return new ResultResponse<T>(responseCode.getCode(), errMsg, null);
    }

    /**
     * .请求应答失败
     */
    public static <T> ResultResponse<T> toFailureResult(Integer code, String errMsg) {
        return new ResultResponse<T>(code, errMsg, null);
    }
}
