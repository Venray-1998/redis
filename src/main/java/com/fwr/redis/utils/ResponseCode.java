package com.fwr.redis.utils;

/**
 * @author fwr
 * @date 2020-11-18
 */
public enum ResponseCode {
    /**
     * SUCCESS
     */
    SUCCESS(0, "操作成功"),
    /**
     * FAILURE
     */
    FAILURE(-1, "操作失败"),
    /**
     * ACCESS_TOKEN_ERROR
     */
    ACCESS_TOKEN_ERROR(400, "用户登录令牌失效"),
    /**
     * UNAUTHORIZED
     */
    UNAUTHORIZED(401, "用户未登录"),
    /**
     * UNAUTHORIZED
     */
    AUTH_ERROR(402, "用户名或密码错误"),
    /**
     * InnerError
     */
    INNER_ERROR(500, "系统内部错误"),
    /**
     * ParameterValidError
     */
    PARAMETER_VALID_ERROR(501, "参数验证错误"),
    /**
     * AccessDenied
     */
    ACCESS_DENIED(502, "用户没有权限访问");

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
