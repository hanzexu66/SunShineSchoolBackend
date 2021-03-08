package com.hzx.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class GsonUtil {

    /**
     * 将json字符串转换为ArrayList
     *
     * @param jsonArray
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonToList(String jsonArray, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        Gson gson = new Gson();
        JsonArray array = JsonParser.parseString(jsonArray).getAsJsonArray();
        for (JsonElement obj : array) {
            list.add(gson.fromJson(obj, clazz));
        }
        return list;
    }

    /**
     * 将字符串转换为Object对象
     *
     * @param jsonObj
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJsonToObject(String jsonObj, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObj, clazz);
    }


    /**
     * 将Object对象转换成为Json字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String objectToJson(T obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}
