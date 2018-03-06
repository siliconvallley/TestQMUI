package com.isoftstone.huidingc.testqmui.network.utils;

import com.isoftstone.huidingc.testqmui.base.BaseUrl;
import com.isoftstone.huidingc.testqmui.network.ProgressListener;
import com.isoftstone.huidingc.testqmui.network.custom.ProgressResponseBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @auther huidingc
 * @date 2018/2/6 16:46
 * @description DownRetrofit
 */

public class DownRetrofit {
    /**
     * Retrofit对象
     */
    public Retrofit retrofit = null;
    /**
     * RetrofitUtil 对象
     */
    private static DownRetrofit instance;
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
     * 默认BaseURl
     */
    public static final String BASE_URL = BaseUrl.HOST;



    /**
     * 构造方法
     */
    private DownRetrofit(){

    }

    /**
     * 获取RetrofitUtil
     * @return
     */
    public static synchronized DownRetrofit getInstance(){
        if(instance == null){
            instance = new DownRetrofit();
        }
        return instance;
    }

    /**
     * 创建API服务
     * @param progressListener
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T createService(ProgressListener progressListener,Class<T> clazz){
        return retrofit(progressListener).create(clazz);
    }

    public Retrofit retrofit(ProgressListener progressListener) {
        if(null == retrofit){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            //添加下载进度拦截器
            addDownLoadInInterceptor(builder,progressListener);

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
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     * 添加下载进度转换拦截器
     * @param builder
     * @param progressListener
     */
    private void addDownLoadInInterceptor(OkHttpClient.Builder builder, final ProgressListener progressListener) {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response.newBuilder()
                        .body(new ProgressResponseBody(response.body(),progressListener))
                        .build();
            }
        };
        builder.addInterceptor(interceptor);
    }
}
