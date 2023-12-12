package me.xuanxi.spark.api.web;

import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;
import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.service.SportEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/spark")
public class PostController {
    private final SportEntityService sportEntityService;
    private static final Logger logger = LoggerFactory.getLogger(SportEntity.class);

    @Autowired
    private PostController(SportEntityService sportEntityService){
        this.sportEntityService = sportEntityService;
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody String request, HttpServletRequest httpRequest){
        String clientIP = httpRequest.getHeader("X-Forwarded-For");
        logger.info("Received request from IP@{}", clientIP);
        try{
            SportEntity s = SportEntity.fromJson(request);
            sportEntityService.saveSportEntity(s);
        }catch (Exception e) {
            if (e instanceof JsonSyntaxException) {
                logger.error("---Exception: Json Syntax Error---");
            } else if (e instanceof DateTimeParseException) {
                logger.error("---Exception: Date Time Parse Error---");
            } else if (e instanceof IllegalArgumentException) {
                logger.error("---Exception: Illegal Argument---");
            } else {
                logger.error("---Exception: POST Failed---");
            }
            logger.error("{}", request);
            logger.error(e.toString());
            logger.error("----------------------------");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Received: " + request);
    }
}
