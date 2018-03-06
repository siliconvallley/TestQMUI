package com.isoftstone.huidingc.testqmui.network.custom;

import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.network.utils.GsonUtil;
import com.isoftstone.huidingc.testqmui.utils.LogUtils;

import io.reactivex.functions.Function;

/**
 * @autor huidingc
 * @date 2018/1/31
 * @description HttpResultFunc 拦截服务器返回的数据，返回我们需要的数据
 * @version
 */
public class HttpResultFunc implements Function<String,BaseData> {
    private static final String TAG = "HttpResultFunc";

    @Override
    public BaseData apply(String s) throws Exception {
        LogUtils.e(TAG,s);
        return GsonUtil.toObject(s);
    }
}
