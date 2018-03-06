package com.isoftstone.huidingc.testqmui.contract;

import android.content.Context;

import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.entity.User;
import com.isoftstone.huidingc.testqmui.network.exception.ApiException;
import java.util.HashMap;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @autor huidingc
 * @date 2018/2/7
 * @description UserContract
 * @version
 */
public interface UserContract {
    interface Model {
        Observable<BaseData> getUser(Context context, HashMap<String,String> map);
    }

    interface View {
        void showSuccess(User user);
        void showError(ApiException ex);
        void obtainDisposable(Disposable disposable);
    }

    interface Presenter {
        void login(HashMap<String,String> map);
    }
}
