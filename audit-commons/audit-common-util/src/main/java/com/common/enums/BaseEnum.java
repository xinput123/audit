package com.common.enums;

public enum BaseEnum {
    GENDER_MAN(1,"男"),
    GENDER_WOMAN(0,"女"),


    STATUS_ACTIVE(1,"active"),
    STATUS_UNACTIVE(0,"unActive"),
    STATUS_DELETED(-1,"deleted");

    private int code;
    private String message;

    BaseEnum(int code, String message) {
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
