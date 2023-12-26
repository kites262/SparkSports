package me.xuanxi.spark.api.web;

import jakarta.servlet.http.HttpServletRequest;
import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.data.SportType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RestController
@RequestMapping(Paths.ROOT)
public class GetController {
    private static final Logger logger = LoggerFactory.getLogger(GetController.class);

    @GetMapping(Paths.test)
    public String test(HttpServletRequest httpRequest) {
        String clientIP = httpRequest.getHeader("X-Forwarded-For");
        logger.info("Received " + Paths.test + " from IP@{}", clientIP);
        SportEntity entity = new SportEntity();
        entity.setUserid(23009202333L);
        entity.setType(SportType.basketball);
        entity.setDuration(8080);
        entity.setDateTime(LocalDateTime.now());
        return entity.toJson();
    }
}
