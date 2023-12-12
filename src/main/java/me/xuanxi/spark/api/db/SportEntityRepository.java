package me.xuanxi.spark.api.db;

import me.xuanxi.spark.api.data.SportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SportEntityRepository extends MongoRepository<SportEntity, String> {

}
