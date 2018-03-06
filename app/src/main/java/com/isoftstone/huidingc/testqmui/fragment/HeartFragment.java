package com.isoftstone.huidingc.testqmui.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.isoftstone.huidingc.testqmui.R;
import com.isoftstone.huidingc.testqmui.adpater.ImgAdapter;
import com.isoftstone.huidingc.testqmui.base.BaseData;
import com.isoftstone.huidingc.testqmui.base.BaseFragment;
import com.isoftstone.huidingc.testqmui.base.BaseUrl;
import com.isoftstone.huidingc.testqmui.contract.UserContract;
import com.isoftstone.huidingc.testqmui.entity.User;
import com.isoftstone.huidingc.testqmui.entity.Weather;
import com.isoftstone.huidingc.testqmui.network.ApiService;
import com.isoftstone.huidingc.testqmui.network.NetCallBack;
import com.isoftstone.huidingc.testqmui.network.ProgressListener;
import com.isoftstone.huidingc.testqmui.network.custom.CustomObserver;
import com.isoftstone.huidingc.testqmui.network.custom.ProgressRequestBody;
import com.isoftstone.huidingc.testqmui.network.exception.ApiException;
import com.isoftstone.huidingc.testqmui.network.utils.DownRetrofit;
import com.isoftstone.huidingc.testqmui.network.utils.FileUtils;
import com.isoftstone.huidingc.testqmui.network.utils.GsonUtil;
import com.isoftstone.huidingc.testqmui.network.custom.HttpResultFunc;
import com.isoftstone.huidingc.testqmui.network.utils.RetrofitUtil;
import com.isoftstone.huidingc.testqmui.presenter.UserPresenter;
import com.isoftstone.huidingc.testqmui.utils.LogUtils;
import com.isoftstone.huidingc.testqmui.utils.SizeUtils;
import com.isoftstone.huidingc.testqmui.utils.ToastUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import static android.app.Activity.RESULT_OK;

/**
 * @autor huidingc
 * @date 2018/1/26
 * @description HeartFragment
 */
public class HeartFragment extends BaseFragment implements UserContract.View {
    private static final String TAG = "HeartFragment";
    private static final int REQUEST_CODE_CHOOSE = 0x100;

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_weather)
    Button btWeather;
    @BindView(R.id.bt_upload)
    Button btUpload;
    @BindView(R.id.bt_download)
    Button btDownload;
    @BindView(R.id.rv_img)
    RecyclerView rvImg;
    @BindView(R.id.bt_img)
    Button btImg;
    @BindView(R.id.num_progress)
    NumberProgressBar numProgress;
    @BindView(R.id.bt_file_one)
    Button btFileOne;
    @BindView(R.id.bt_multiple)
    Button btMultiple;
    @BindView(R.id.bt_login_mvp)
    Button btLoginMvp;

    Unbinder unbinder;
    private Activity activity;
    private String name;
    private String pass;
    private List<String> list;
    private ImgAdapter adapter;
    private String token = "";
    List<String> fileList;
    private UserContract.Presenter presenter;
    private Disposable dis;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    public static HeartFragment getInstance(String data){
        HeartFragment fragment = new HeartFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login_layout;
    }

    @Override
    protected void initViews(View view) {
        unbinder = ButterKnife.bind(this,view);
        presenter = new UserPresenter(activity,this);
    }

    @Override
    protected void initListener() {
        btLogin.setOnClickListener(onClickListener);
        btWeather.setOnClickListener(onClickListener);
        btImg.setOnClickListener(onClickListener);
        btUpload.setOnClickListener(onClickListener);
        btDownload.setOnClickListener(onClickListener);
        btFileOne.setOnClickListener(onClickListener);
        btMultiple.setOnClickListener(onClickListener);
        btLoginMvp.setOnClickListener(onClickListener);
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        fileList = new ArrayList<>();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        rvImg.setLayoutManager(layoutManager);
        adapter = new ImgAdapter(activity,list);
        rvImg.setAdapter(adapter);
        rvImg.setNestedScrollingEnabled(false);
    }

    /**
     * View的点击事件
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_login:
                    login();
                    break;
                case R.id.bt_weather:
                    weather();
                    break;
                case R.id.bt_img:
                    choiceImg();
                    break;
                case R.id.bt_upload:
                    upLoad();
                    break;
                case R.id.bt_download:
                    downLoadFile();
                    break;
                case R.id.bt_file_one:
                    upLoadFileOne();
                    break;
                case R.id.bt_multiple:
                    break;
                case R.id.bt_login_mvp:
                    loginMvp();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 登录
     */
    private void loginMvp() {
        name = etName.getText().toString().trim();
        pass = etPass.getText().toString().trim();

        HashMap<String,String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",pass);
        presenter.login(map);
    }

    /**
     * 登录
     */
    private void login() {
        name = etName.getText().toString().trim();
        pass = etPass.getText().toString().trim();
        ApiService service = RetrofitUtil.getInstance().createService(activity, ApiService.class);

        HashMap<String,String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",pass);
        service.loginMap(map)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver(loginCallBack));
    }

    /**
     * 登录反馈
     */
    NetCallBack loginCallBack = new NetCallBack() {
        @Override
        public void onSubscribe(Disposable disposable) {
            LogUtils.e(TAG,"请求开始");
        }

        @Override
        public void onSuccess(BaseData baseData) {
            User user = (User) GsonUtil.jsonToObj(baseData.getData(),User.class);
            token = user.getToken();
            LogUtils.e(TAG,user.getRealName()+"");
        }

        @Override
        public void onError(ApiException exception) {
            exception.printStackTrace();
            LogUtils.e(TAG,exception.getErrMsg());
        }

        @Override
        public void onComplete() {
            LogUtils.e(TAG,"请求完成");
        }
    };

    /**
     * 获取天气
     */
    private void weather() {
        RetrofitUtil.getInstance().retrofit(activity).create(ApiService.class)
                .getWeather(BaseUrl.BASE_URL+"v5/weather?city=成都&key=a6f76d30617d45c683ee211c9b053c91")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Weather weather) {
                        LogUtils.e(TAG,weather.getHeWeather5().size()+"");
                        for (int i = 0; i < weather.getHeWeather5().size(); i++) {
                            LogUtils.e(TAG,weather.getHeWeather5().get(i).getBasic()
                                    .getCity());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        LogUtils.e(TAG,"失败");
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.e(TAG,"成功");
                    }
                });
    }

    /**
     * 选择图片
     */
    private void choiceImg() {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.request(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if(aBoolean){
                            Matisse.from(HeartFragment.this)
                                    .choose(MimeType.ofAll())
                                    .countable(true)
                                    .capture(true)
                                    .captureStrategy(
                                            new CaptureStrategy(true,"com.isoftstone.huidingc.testqmui.fileprovider"))
                                    .maxSelectable(9)
                                    .gridExpectedSize(SizeUtils.dp2px(120))
                                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                                    .thumbnailScale(0.85f)
                                    .imageEngine(new GlideEngine())
                                    .forResult(REQUEST_CODE_CHOOSE);
                        }else {
                            ToastUtils.setBgColor(getResources().getColor(R.color.custom_status_color));
                            ToastUtils.showShort("权限拒绝");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 上传文件 单双文件上传
     */
    private void upLoad() {
        if(list.isEmpty()){
            return;
        }
        ApiService service = RetrofitUtil.getInstance().createService(activity, ApiService.class);
        HashMap<String, RequestBody> map = new HashMap<>();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        for (int i = 0; i < list.size(); i++) {
            File file = new File(list.get(i));
            RequestBody requestBody = RequestBody.create(FileUtils.guessMimeType(file.getName()), file);
            //RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            //"file"这个key是服务器给我们的key
            builder.addFormDataPart("file",file.getName(),requestBody);
        }
        map.put("file",new ProgressRequestBody(builder.build(),progressListener));
        service.uploadFile(token,map)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver(fileCallBack));
    }

    /**
     * 文件上传监听
     */
    NetCallBack fileCallBack = new NetCallBack() {
        @Override
        public void onSubscribe(Disposable disposable) {

        }

        @Override
        public void onSuccess(BaseData baseData) {
            try {
                JSONArray array = new JSONArray(baseData.getData());
                for (int i = 0; i < array.length(); i++) {
                    fileList.add(array.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtils.e(TAG,"成功");
        }

        @Override
        public void onError(ApiException exception) {
            exception.printStackTrace();
            LogUtils.e(TAG,exception.getErrMsg());
        }

        @Override
        public void onComplete() {
            LogUtils.e(TAG,"完成");
        }
    };

    /**
     * 上传进度监听
     */
    ProgressListener progressListener = new ProgressListener() {
        @Override
        public void onProgress(long bytesRead, long contentLength, boolean done) {
            int progress = (int) (((float)bytesRead/(float)contentLength)*100);
            Message message = handler.obtainMessage();
            message.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("progress",progress);
            message.setData(bundle);
            handler.sendMessage(message);
            LogUtils.e(TAG,bytesRead+"-->"+contentLength);
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    int progress = msg.getData().getInt("progress");
                    numProgress.setProgress(progress);
                    break;
                case 1:
                    int downProgress = msg.getData().getInt("progress");
                    numProgress.setProgress(downProgress);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK){
            list.addAll(Matisse.obtainPathResult(data));
            adapter.updateList(list);
        }
    }

    /**
     * 下载文件
     */
    private void downLoadFile() {
        final String filePath = fileList.get(0);
        int lastIndexOf = filePath.lastIndexOf("/");
        final String name = filePath.substring(lastIndexOf+1,filePath.length());
        final String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                +"/testqmui/"+name;

        ApiService service = DownRetrofit.getInstance().createService(downListener, ApiService.class);
        service.downLoadFile(BaseUrl.HOST + filePath)
                .map(new Function<ResponseBody, InputStream>() {
                    @Override
                    public InputStream apply(ResponseBody responseBody) throws Exception {
                        return responseBody.byteStream();
                    }
                })
                .subscribeOn(Schedulers.io())
                /*.doOnNext(new Consumer<InputStream>() {
                    @Override
                    public void accept(InputStream inputStream) throws Exception {
                        FileUtils.writeFileToSdcard(inputStream,path);
                    }
                })*/
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<InputStream>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtils.e(TAG,"下载开始");
                    }

                    @Override
                    public void onNext(InputStream inputStream) {
                        FileUtils.writeFileToSdcard(inputStream,path);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(TAG,"下载失败");
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.e(TAG,"下载完成");
                    }
                });
                
    }

    /**
     * 下载进度
     */
    ProgressListener downListener = new ProgressListener() {
        @Override
        public void onProgress(long bytesRead, long contentLength, boolean done) {
            int progress = (int) (((float)bytesRead/(float)contentLength)*100);
            Message message = handler.obtainMessage();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putInt("progress",progress);
            message.setData(bundle);
            handler.sendMessage(message);
            LogUtils.e(TAG,bytesRead+"-->"+contentLength);
        }
    };

    /**
     * 上传单张文件
     */
    private void upLoadFileOne() {
        ApiService service = RetrofitUtil.getInstance().createService(activity, ApiService.class);
        File file = new File(list.get(0));
        RequestBody requestBody = RequestBody.create(FileUtils.guessMimeType(file.getName()), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file",file.getName(),
                new ProgressRequestBody(requestBody,uploadProgressListener));
        service.upload(token,body)
                .map(new HttpResultFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver(uploadFileCallBack));
    }

    NetCallBack uploadFileCallBack = new NetCallBack() {
        @Override
        public void onSubscribe(Disposable disposable) {

        }

        @Override
        public void onSuccess(BaseData baseData) {
            try {
                JSONArray array = new JSONArray(baseData.getData());
                for (int i = 0; i < array.length(); i++) {
                    LogUtils.e(TAG,array.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(ApiException exception) {
            LogUtils.e(TAG,exception.getErrMsg());
        }

        @Override
        public void onComplete() {
            LogUtils.e(TAG,"完成");
        }
    };

    ProgressListener uploadProgressListener = new ProgressListener() {
        @Override
        public void onProgress(long bytesRead, long contentLength, boolean done) {
            LogUtils.e(TAG,bytesRead+"-->"+contentLength);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null){
            unbinder.unbind();
        }
        if(null != dis && !dis.isDisposed()){
            dis.dispose();
        }
    }

    @Override
    public void showSuccess(User user) {
        token = user.getToken();
        LogUtils.e(TAG,user.getRealName());
    }

    @Override
    public void showError(ApiException ex) {
        LogUtils.e(TAG,ex.getErrMsg());
        ex.getException().printStackTrace();
    }

    @Override
    public void obtainDisposable(Disposable disposable) {
        dis = disposable;
    }
}
