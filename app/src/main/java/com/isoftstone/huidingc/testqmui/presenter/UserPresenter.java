package com.isoftstone.huidingc.testqmui.presenter;

import android.content.Context;
import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.contract.UserContract;
import com.isoftstone.huidingc.testqmui.entity.User;
import com.isoftstone.huidingc.testqmui.model.UserModel;
import com.isoftstone.huidingc.testqmui.network.NetCallBack;
import com.isoftstone.huidingc.testqmui.network.custom.CustomObserver;
import com.isoftstone.huidingc.testqmui.network.exception.ApiException;
import com.isoftstone.huidingc.testqmui.network.utils.GsonUtil;
import com.isoftstone.huidingc.testqmui.utils.LogUtils;
import java.util.HashMap;
import io.reactivex.disposables.Disposable;

/**
 * @autor huidingc
 * @date 2018/2/7
 * @description UserPresenter
 * @version
 */
public class UserPresenter implements UserContract.Presenter {
    private static final String TAG = "UserPresenter";
    private UserContract.View view;
    private UserContract.Model model;
    private Context context;

    public UserPresenter(Context context,UserContract.View view){
        this.context = context;
        this.view = view;
        model = new UserModel();
    }

    @Override
    public void login(HashMap<String, String> map) {
        model.getUser(context,map)
                .subscribe(new CustomObserver(callBack));
    }

    NetCallBack callBack = new NetCallBack() {
        @Override
        public void onSubscribe(Disposable disposable) {
            view.obtainDisposable(disposable);
            LogUtils.e(TAG,"登录开始");
        }

        @Override
        public void onSuccess(BaseData baseData) {
            User user = (User) GsonUtil.jsonToObj(baseData.getData(),User.class);
            view.showSuccess(user);
        }

        @Override
        public void onError(ApiException exception) {
            view.showError(exception);
        }

        @Override
        public void onComplete() {
            LogUtils.e(TAG,"登录完成");
        }
    };
}
