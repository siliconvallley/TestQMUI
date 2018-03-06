package com.isoftstone.huidingc.testqmui.network.custom;

import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.network.NetCallBack;
import com.isoftstone.huidingc.testqmui.network.exception.ApiException;
import com.isoftstone.huidingc.testqmui.network.exception.CodeException;
import com.isoftstone.huidingc.testqmui.network.exception.ExceptionFactory;
import com.isoftstone.huidingc.testqmui.utils.NetworkUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @auther huidingc
 * @date 2018/2/1 10:15
 * @description CustomObserver
 */
public class CustomObserver implements Observer<BaseData> {
    private NetCallBack callBack;

    public CustomObserver(NetCallBack callBack){
        this.callBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {
        callBack.onSubscribe(d);
    }

    @Override
    public void onNext(BaseData baseData) {
        if(baseData.getStatus() == CodeException.SUCCESS_CODE){
            callBack.onSuccess(baseData);
        }else if(baseData.getStatus() == CodeException.SESSION_OUT){
            ApiException apiException = new ApiException();
            apiException.setCode(CodeException.SESSION_OUT);
            apiException.setErrMsg(CodeException.SESSION_OUT_MSG);
            callBack.onError(apiException);
        }else{
            ApiException apiException = new ApiException();
            apiException.setCode(baseData.getStatus());
            apiException.setErrMsg(baseData.getMsg());
            callBack.onError(apiException);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(!NetworkUtils.isConnected()){
            ApiException apiException = new ApiException(e);
            apiException.setException(e);
            apiException.setCode(CodeException.NETWORK_ERROR);
            apiException.setErrMsg(CodeException.NETWORK_ERROR_MSG);
            callBack.onError(apiException);
        }else{
            ApiException apiException = ExceptionFactory.handleException(e);
            callBack.onError(apiException);
        }
    }

    @Override
    public void onComplete() {
        callBack.onComplete();
    }
}
