package io.dblog.common.util.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * {@code JSONutils}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class JSONutils {

    public static Gson getGson() {
        return new Gson();
    }

    public static String toJson(Object obj) {
        return getGson().toJson(obj);
    }

    public static Map fromJson(String json) {
        return getGson().fromJson(json, Map.class);
    }

    public static <T> T fromJson(String json, Type typeOf) {
        return getGson().fromJson(json, typeOf);
    }

    public static <T> T fromJson(String json, Class<T> classType) {
        return getGson().fromJson(json, classType);
    }
}
