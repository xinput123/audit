package com.common.enums;

public enum ResponseEnum {
    OK(0,"OK"),
    PARAM_EXCEPTION(400,"error param"),
    ERROR(500,"ERROR");

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
