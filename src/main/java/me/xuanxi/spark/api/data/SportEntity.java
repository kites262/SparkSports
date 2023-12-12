package me.xuanxi.spark.api.data;

import com.google.gson.JsonSyntaxException;
import lombok.Data;
import me.xuanxi.spark.api.utils.JsonUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Data
@Document(collection = "sportEntity")
public class SportEntity {

    @Id private String id;
    private long userid;
    private LocalDateTime date;
    private SportType type;
    private int duration;

    public String toJson(){
        return JsonUtils.toJson(this);
    }

    public static SportEntity parseSportEntity(String json) throws JsonSyntaxException, DateTimeParseException {
        return JsonUtils.parseSportEntity(json);
    }
}
