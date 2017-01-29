package com.wcms.util.gson;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/1/29.
 */
public class IntegerAdapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            if (json.getAsString().equals("") || json.getAsString().equals("null")) {//定义为int类型,如果后台返回""或者null,则返回0
                return 0;
            }
        } catch (Exception ignore) {
        }
        try {
            return json.getAsInt();
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Integer src, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(src);
    }
}
