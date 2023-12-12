package me.xuanxi.spark.api.data;

import com.google.gson.Gson;
import lombok.Data;
import me.xuanxi.spark.api.utils.DateUtils;
import me.xuanxi.spark.api.utils.JsonUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "sportEntity")
public class SportEntity {
    private static final Gson gson = new Gson();

    @Id private String id;
    private long userid;
    private LocalDateTime dateTime;
    private SportType type;
    private int duration;

    public void setDateTimeString(String str){
        this.dateTime = DateUtils.parseDateTime(str);
    }

    public String toJson(){
        return JsonUtils.toJson(this);
    }

    public static SportEntity fromJson(String json){
        return JsonUtils.fromJson(json);
    }
}
