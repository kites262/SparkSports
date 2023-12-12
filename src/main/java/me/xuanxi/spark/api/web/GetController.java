package me.xuanxi.spark.api.web;

import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.data.SportType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/spark")
public class GetController {

    @GetMapping("/test")
    public String test() {
        SportEntity event = new SportEntity();
        //event.setDate(new Date());
        event.setType(SportType.basketball);
        event.setDuration(1);
        event.setUserid(2333333);
        return event.toJson();
    }
}
