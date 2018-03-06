package com.isoftstone.huidingc.testqmui.network;

import com.isoftstone.huidingc.testqmui.entity.Weather;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @auther huidingc
 * @date 2018/1/30 14:59
 * @description ApiService
 */

public interface ApiService {
    /**
     * 登录方法
     * @param userName
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<String> login(@Field("username") String userName, @Field("password") String password);

    /**
     * 登录
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<String> loginMap(@FieldMap HashMap<String,String> map);

    /**
     * 获取天气
     * @param city
     * @param key
     * @return
     */
    @GET("v5/weather")
    Observable<Weather> weather(@Query("city") String city, @Query("key") String key);

    /**
     * 全链接访问
     * @param url
     * @return
     */
    @GET
    Observable<Weather> getWeather(@Url String url);

    /**
     * 单、多文件上传
     * 也可以携带参数过去
     * @param token
     * @param files
     * @return
     */
    @Multipart
    @POST("file/batch/upload")
    Observable<String> uploadFile(@Header("X-Token") String token, @PartMap Map<String, RequestBody> files);

    /**
     * 上传单张文件
     * @param token
     * @param file
     * @return
     */
    @Multipart
    @POST("file/batch/upload")
    Observable<String> upload(@Header("X-Token") String token, @Part MultipartBody.Part file);

    /**
     * 文件下载
     * @return
     */
    @Streaming
    @GET
    Observable<ResponseBody> downLoadFile(@Url String url);
}
