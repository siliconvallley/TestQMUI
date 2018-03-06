package com.isoftstone.huidingc.testqmui.network;

import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.network.exception.ApiException;

import io.reactivex.disposables.Disposable;

/**
 * @autor huidingc
 * @date 2018/2/1
 * @description NetCallBack
 * @version 网络访问接口处理类
 */
public interface NetCallBack {
    /**
     * 访问开始
     * @param disposable
     */
    void onSubscribe(Disposable disposable);

    /**
     * 访问成功
     * @param baseData
     */
    void onSuccess(BaseData baseData);

    /**
     * 网络访问出错
     * @param exception
     */
    void onError(ApiException exception);

    /**
     * 访问完成
     */
    void onComplete();
}
