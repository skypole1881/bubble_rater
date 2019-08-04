package com.bubble.enums;

public enum HttpCodeEnum {
    OK(200), CREATED(201), UNAUTHORIZED(401), FORBIDDEN(403), SERVER_ERROR(500);

    Integer code;

    private HttpCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
