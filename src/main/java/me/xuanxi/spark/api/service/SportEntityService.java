package me.xuanxi.spark.api.service;

import me.xuanxi.spark.api.data.SportEntity;
import me.xuanxi.spark.api.db.SportEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportEntityService {
    private final SportEntityRepository sportEntityRepository;

    @Autowired
    public SportEntityService(SportEntityRepository sportEntityRepository){
        this.sportEntityRepository = sportEntityRepository;
    }

    public void saveSportEntity(SportEntity entity){
        sportEntityRepository.save(entity);
    }


}
