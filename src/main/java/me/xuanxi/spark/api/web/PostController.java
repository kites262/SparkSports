package me.xuanxi.spark.api.web;

import com.google.gson.JsonSyntaxException;
import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.db.SportEntityRepository;
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
    private final SportEntityRepository sportEntityRepository;
    private static final Logger logger = LoggerFactory.getLogger(SportEntity.class);

    @Autowired
    private PostController(SportEntityRepository sportEntityRepository){
        this.sportEntityRepository = sportEntityRepository;
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody String request){
        logger.info("Received:\n {}", request);
        try{
            SportEntity s = SportEntity.parseSportEntity(request);
            sportEntityRepository.save(s);
        }catch (JsonSyntaxException e) {
            logger.error("---Exception: Json Syntax Error---");
            logger.error("{}", request);
            logger.error(e.toString());
            logger.error("----------------------------");
        }catch (DateTimeParseException e) {
            logger.error("---Exception: Date Time Parse Error---");
            logger.error("{}", request);
            logger.error(e.toString());
            logger.error("----------------------------");
        }catch (Exception e){
            logger.error("---Exception: POST Failed---");
            logger.error("{}", request);
            logger.error(e.toString());
            logger.error("----------------------------");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Received: " + request);
    }
}
