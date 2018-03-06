package com.isoftstone.huidingc.testqmui.network.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.isoftstone.huidingc.testqmui.BuildConfig;
import com.isoftstone.huidingc.testqmui.base.BaseUrl;
import com.isoftstone.huidingc.testqmui.utils.LogUtils;
import com.isoftstone.huidingc.testqmui.utils.NetworkUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @autor huidingc
 * @date 2018/1/30
 * @description RetrofitUtil
 */
public class RetrofitUtil {
    private static final String TAG = "RetrofitUtil";
    /**
     * Retrofit对象
     */
    public Retrofit retrofit = null;
    /**
     * 默认BaseURl
     */
    public static final String BASE_URL = BaseUrl.HOST;
    /**
     * 连接超时时间
     */
    private static final int DEFAULT_CONNECT_TIMEOUT = 15;
    /**
     * 读取超时时间
     */
    private static final int DEFAULT_READ_TIMEOUT = 20;
    /**
     * 写入超时时间
     */
    private static final int DEFAULT_WRITE_TIMEOUT = 20;
    /**
     * 最大缓存容量
     */
    private static final long CACHE_MAXSIZE = 1024 * 1024 * 50L;
    /**
     * get方法
     */
    private static final String METHOD_GET = "GET";
    /**
     * post方法
     */
    private static final String METHOD_POST = "POST";
    /**
     * RetrofitUtil 对象
     */
    private static RetrofitUtil instance;

    /**
     * 构造方法
     */
    private RetrofitUtil(){

    }

    /**
     * 获取RetrofitUtil
     * @return
     */
    public static synchronized RetrofitUtil getInstance(){
        if(instance == null){
            instance = new RetrofitUtil();
        }
        return instance;
    }

    /**
     * 创建API服务
     * @param context
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T createService(Context context,Class<T> clazz){
        return retrofit(context).create(clazz);
    }

    /**
     * 全局配置Retrofit
     *
     * @param context
     * @return
     */
    public Retrofit retrofit(Context context) {
        if (null == retrofit) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            //设置缓存
            addCacheInterceptor(builder, context);
            //公共参数
            //addPublicParams(builder);
            //设置头
            addHeader(builder);
            //log信息拦截器 设置debug模式
            addLogInterceptor(builder);

            //设置连接超时
            builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
            //设置读取超时
            builder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
            //设置写入超时
            builder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            //设置结束，然后build
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    //添加json字符串解析
                    .addConverterFactory(ScalarsConverterFactory.create())
                    //Gosn解析
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     * 设置缓存
     *
     * @param builder
     * @param context
     */
    private static void addCacheInterceptor(OkHttpClient.Builder builder, final Context context) {
        File cacheFile = new File(context.getExternalCacheDir(), "testqmui_cache");
        Cache cache = new Cache(cacheFile, CACHE_MAXSIZE);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetworkUtils.isConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetworkUtils.isConnected()) {
                    int maxAge = 0;
                    //有网络是这是缓存为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .removeHeader("Pragma")
                            .build();
                } else {
                    //无网络时，设置缓存时间为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        builder.addInterceptor(cacheInterceptor).cache(cache);
    }

    /**
     * 添加公共参数
     *
     * @param builder
     */
    private static void addPublicParams(OkHttpClient.Builder builder) {
        Interceptor publicParamsInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (request.method().equals(METHOD_GET)) {
                    HttpUrl httpUrl = request.url().newBuilder()
                            .addQueryParameter("", "")
                            .addQueryParameter("", "")
                            .build();
                    request = request.newBuilder().url(httpUrl).build();
                } else if (request.method().equals(METHOD_POST)) {
                    //post请求追加参数
                    FormBody.Builder newBody = new FormBody.Builder();
                    newBody.addEncoded("", "").build();
                    //拦截请求中用户传入的数据，把参数遍历放入新的body里面，然后进行一块提交
                    FormBody oldBody = (FormBody) request.body();
                    for (int i = 0; i < oldBody.size(); i++) {
                        newBody.addEncoded(oldBody.encodedName(i), oldBody.encodedValue(i));
                    }
                    request = request.newBuilder().post(newBody.build()).build();

                    if (request.body() instanceof FormBody) {
                        FormBody.Builder bodyBuilder = new FormBody.Builder();
                        FormBody formBody = (FormBody) request.body();
                        for (int i = 0; i < formBody.size(); i++) {
                            bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                        }
                        formBody = bodyBuilder
                                .addEncoded("version", "xxx")
                                .addEncoded("device", "Android")
                                .addEncoded("timestamp", String.valueOf(System.currentTimeMillis()))
                                .build();
                        request = request.newBuilder().post(formBody).build();
                    }
                }
                return chain.proceed(request);
            }
        };
        builder.addInterceptor(publicParamsInterceptor);
    }

    /**
     * 添加头部
     *
     * @param builder
     */
    private static void addHeader(OkHttpClient.Builder builder) {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder()
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("Accept", "application/json;charset=UTF-8")
                        .build();
                return chain.proceed(request);
            }
        };
        builder.addInterceptor(headerInterceptor);
    }

    /**
     * 添加log打印
     *
     * @param builder
     */
    private static void addLogInterceptor(OkHttpClient.Builder builder) {
        //判断如果是debug模式，就添加拦截器
        if(BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    //打印出需要的数据
                    LogUtils.e(TAG,message);
                }
            });
            //BODY的数据太多，所以直接简单的使用BASIC
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
    }
}
