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

import java.nio.file.Path;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping(Paths.ROOT)
public class PostController {
    private final SportEntityService sportEntityService;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostController(SportEntityService sportEntityService){
        this.sportEntityService = sportEntityService;
    }

    @PostMapping(Paths.update)
    public ResponseEntity<String> update(@RequestBody String request, HttpServletRequest httpRequest){
        String clientIP = httpRequest.getHeader("X-Forwarded-For");
        logger.info("Received " + Paths.update + " from IP@{}", clientIP);
        try{
            SportEntity s = SportEntity.fromJson(request);
            sportEntityService.saveSportEntity(s);
            //System.out.println(s.getDateTime().toString());
        }catch (Exception e) {
            if (e instanceof JsonSyntaxException) {
                logger.error("\n---Exception: Json Syntax Error---");
            } else if (e instanceof DateTimeParseException) {
                logger.error("\n---Exception: Date Time Parse Error---");
            } else if (e instanceof IllegalArgumentException) {
                logger.error("\n---Exception: Illegal Argument---");
            } else {
                logger.error("\n---Exception: POST Failed---");
            }
            logger.error("{}", request);
            logger.error(e.toString());
            logger.error("\n----------------------------");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Received.");
    }
}
