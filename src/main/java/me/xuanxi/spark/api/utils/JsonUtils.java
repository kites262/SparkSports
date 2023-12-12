package me.xuanxi.spark.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.data.SportType;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new JsonLocalDateTimeSerializer())
            .create();

    public static String toJson(SportEntity sportEntity){
        return gson.toJson(sportEntity);
    }

    public static SportEntity fromJson(String json) throws JsonSyntaxException, DateTimeParseException, IllegalArgumentException{
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        SportEntity se = new SportEntity();
        se.setUserid(jsonObject.get("userid").getAsLong());
        se.setDateTimeString(jsonObject.get("date").getAsString());
        se.setType(SportType.fromString(jsonObject.get("type").getAsString()));
        se.setDuration(jsonObject.get("duration").getAsInt());
        return se;
    }
}
