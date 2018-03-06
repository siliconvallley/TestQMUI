package com.isoftstone.huidingc.testqmui.network.exception;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @version 自定义异常码
 * @autor huidingc
 * @date 2018/2/1
 * @description CodeException
 */
public class CodeException {
    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR = 0x10;
    public static final String NETWORK_ERROR_MSG = "当前网络不可用";
    /**
     * Http错误
     */
    public static final int HTTP_ERROR = 0x20;
    public static final String HTTP_ERROR_MSG = "您的网络状况不佳，请检查网络连接";
    public static final String CONNECT_ERROR_MSG = "连接服务器失败";
    /**
     * json解析异常
     */
    public static final int JSON_ERROR = 0x30;
    public static final String JSON_ERROR_MSG = "无法解析的内容";
    /**
     * 未知异常
     */
    public static final int UNKNOWN_ERROR = 0x40;
    public static final String UNKNOWN_ERROR_MSG = "未知错误";
    /**
     * 运行时异常-包含自定义异常
     */
    public static final int RUNTIME_ERROR = 0x50;
    /**
     * 域名解析异常
     */
    public static final int UNKNOWNHOST_ERROR = 0x60;
    public static final String UNKNOWNHOST_ERROR_MSG = "无法解析的域名";


    /**
     * Http对应的状态码
     */
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    /**
     * 客户端输入参数错误
     */
    public static final int NOT_FOUND = 404;
    public static final int REQUEST_TIMEOUT = 408;
    /**
     * 服务器异常
     */
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;

    /**
     * 成功码
     */
    public static final int SUCCESS_CODE = 200;
    /**
     * 登录超时
     */
    public static final int SESSION_OUT = 250;
    public static final String SESSION_OUT_MSG = "登录超时";

    /*@IntDef({NETWORK_ERROR,HTTP_ERROR,JSON_ERROR,UNKNOWN_ERROR,RUNTIME_ERROR,UNKOWNHOST_ERROR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodeEp{

    }*/
}
