package me.xuanxi.spark.api.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.data.SportType;

import java.time.format.DateTimeParseException;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJson(Object src){
        return gson.toJson(src);
    }

    public static SportEntity parseSportEntity(String json) throws JsonSyntaxException, DateTimeParseException {
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        SportEntity se = new SportEntity();
        se.setUserid(jsonObject.get("userid").getAsLong());
        se.setDate(DateUtils.parseDate(jsonObject.get("date").getAsString()));
        se.setType(SportType.fromString(jsonObject.get("type").getAsString()));
        se.setDuration(jsonObject.get("duration").getAsInt());
        return se;
    }
}
