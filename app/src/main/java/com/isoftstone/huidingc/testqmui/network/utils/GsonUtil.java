package com.isoftstone.huidingc.testqmui.network.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.isoftstone.huidingc.testqmui.base.BaseData;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @auther huidingc
 * @date 2018/2/1 9:14
 * @description GsonUtil
 */
public class GsonUtil {

    /**
     * 统一处理服务器返回的数据
     * @param data
     * @return
     * @throws JSONException
     */
    public static BaseData toObject(String data) throws JSONException {
        BaseData baseData = new BaseData();
        JSONObject jsonObject = new JSONObject(data);
        baseData.setStatus(jsonObject.optInt("status"));
        baseData.setMsg(jsonObject.optString("msg"));
        baseData.setIndex(jsonObject.optInt("index"));
        baseData.setCount(jsonObject.optInt("count"));
        //将data里面的json数据当做字符串处理
        baseData.setData(jsonObject.optString("data"));
        return baseData;
    }

    /**
     * 解析JsonArray中的JsonObject装入ArrayList
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> jsonToArrayList(String json,Class<T> clazz){
        Type type = new TypeToken<ArrayList<JsonObject>>(){}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json,type);
        ArrayList<T> list = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            list.add(new Gson().fromJson(jsonObject,clazz));
        }
        return list;
    }

    /**
     * 将json转换为Object
     * @param json
     * @param clazz
     * @return
     */
    public static Object jsonToObj(String json,Class<?> clazz){
        return new Gson().fromJson(json,clazz);
    }
}
