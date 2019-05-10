package com.itcpay.chapter.exception;

/**
 * 自定义异常
 * @author solofeng
 * @since 2019-5-10 15:35:04
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 7723986354247074983L;

    private int code;

    public CustomException() {
    }

    public CustomException(int code, String message) {
        super(message);
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
