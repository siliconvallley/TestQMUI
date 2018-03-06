package com.isoftstone.huidingc.testqmui.model;

import android.content.Context;

import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.contract.UserContract;
import com.isoftstone.huidingc.testqmui.network.ApiService;
import com.isoftstone.huidingc.testqmui.network.custom.HttpResultFunc;
import com.isoftstone.huidingc.testqmui.network.utils.RetrofitUtil;
import java.util.HashMap;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @autor huidingc
 * @date 2018/2/7
 * @description UserModel
 * @version
 */
public class UserModel implements UserContract.Model {

    @Override
    public Observable<BaseData> getUser(Context context, HashMap<String,String> map) {
        return RetrofitUtil.getInstance().createService(context,ApiService.class)
                .loginMap(map)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
