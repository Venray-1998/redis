package com.fwr.redis.utils;

import lombok.Value;

import java.io.Serializable;

/**
 * @author fwr
 * @date 2020-11-18
 */
@Value
public class ResultResponse<T> implements Serializable {

    Integer code;

    String message;

    T data;
    /**
     * .请求应答成功
     */
    public static <T> ResultResponse<T> toSuccessResult(T data) {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        return new ResultResponse<>(responseCode.getCode(), responseCode.getMessage(), data);
    }

    /**
     * .请求应答成功
     */
    public static <T> ResultResponse<T> toSuccessResult() {
        ResponseCode responseCode = ResponseCode.SUCCESS;
        return new ResultResponse<>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    /**
     * .请求应答失败
     */
    public static <T> ResultResponse<T> toFailureResult(String errMsg) {
        ResponseCode responseCode = ResponseCode.FAILURE;
        return new ResultResponse<>(responseCode.getCode(), errMsg, null);
    }

    /**
     * .请求应答失败
     */
    public static <T> ResultResponse<T> toFailureResult(Integer code, String errMsg) {
        return new ResultResponse<>(code, errMsg, null);
    }
}
