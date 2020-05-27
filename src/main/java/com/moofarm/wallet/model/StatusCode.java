package com.moofarm.wallet.model;

public enum StatusCode {
    SUCCESS(200), NOT_FOUND(404), UNAUTHORIZED(401), INTERNAL_SERVER_ERROR(500), BAD_REQUEST(400);

    private int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static StatusCode getStatusCode(int code) {
        for(StatusCode statusCode: StatusCode.values()) {
            if(statusCode.getCode() == code) {
                return statusCode;
            }
        }

        return INTERNAL_SERVER_ERROR;
    }
}
