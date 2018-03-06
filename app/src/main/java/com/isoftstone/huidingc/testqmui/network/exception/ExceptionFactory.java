package com.isoftstone.huidingc.testqmui.network.exception;

import android.net.ParseException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import org.json.JSONException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.HttpException;

/**
 * @autor huidingc
 * @date 2018/2/1
 * @description ExceptionFactory 异常的统一处理
 * @version
 */
public class ExceptionFactory {


    public static ApiException handleException(Throwable e){
        ApiException exception = new ApiException(e);
        //判断是否是Http异常
        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            exception.setCode(CodeException.HTTP_ERROR);
            exception.setException(e);
            switch (httpException.code()){
                case CodeException.UNAUTHORIZED:
                case CodeException.FORBIDDEN:
                case CodeException.NOT_FOUND:
                case CodeException.REQUEST_TIMEOUT:
                case CodeException.GATEWAY_TIMEOUT:
                case CodeException.INTERNAL_SERVER_ERROR:
                case CodeException.BAD_GATEWAY:
                case CodeException.SERVICE_UNAVAILABLE:
                default:
                    exception.setErrMsg(CodeException.HTTP_ERROR_MSG);
                    break;
            }
        }else if(e instanceof ConnectException || e instanceof SocketTimeoutException){
            exception.setCode(CodeException.HTTP_ERROR);
            exception.setException(e);
            exception.setErrMsg(CodeException.CONNECT_ERROR_MSG);
        }else if(e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException){
            exception.setCode(CodeException.JSON_ERROR);
            exception.setException(e);
            exception.setErrMsg(CodeException.JSON_ERROR_MSG);
        }else if(e instanceof UnknownHostException){
            exception.setCode(CodeException.UNKNOWNHOST_ERROR);
            exception.setException(e);
            exception.setErrMsg(CodeException.UNKNOWNHOST_ERROR_MSG);
        }else {
            exception.setCode(CodeException.UNKNOWN_ERROR);
            exception.setException(e);
            exception.setErrMsg(CodeException.UNKNOWN_ERROR_MSG);
        }
        return exception;
    }
}
