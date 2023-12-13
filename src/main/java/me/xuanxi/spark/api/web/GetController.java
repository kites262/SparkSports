package me.xuanxi.spark.api.web;

import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.data.SportType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(Paths.ROOT)
public class GetController {

    @GetMapping(Paths.test)
    public String test() {
        SportEntity event = new SportEntity();
        event.setUserid(23009202333L);
        event.setType(SportType.basketball);
        event.setDuration(8080);
        event.setDateTime(LocalDateTime.now());
        return event.toJson();
    }
}
