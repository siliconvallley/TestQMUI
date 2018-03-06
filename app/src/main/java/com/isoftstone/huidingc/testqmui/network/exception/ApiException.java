package com.isoftstone.huidingc.testqmui.network.exception;

/**
 * @autor huidingc
 * @date 2018/2/1
 * @description ApiException
 * @version 自定义Exception
 */
public class ApiException extends Exception {
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String errMsg;
    /**
     * 具体的异常
     */
    private Throwable exception;

    public ApiException() {
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, int code, Throwable cause) {
        super(message, cause);
        setCode(code);
        setErrMsg(message);
        setException(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}
