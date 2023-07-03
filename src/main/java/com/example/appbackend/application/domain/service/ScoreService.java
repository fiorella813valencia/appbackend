package com.example.appbackend.application.domain.service;

import com.example.appbackend.application.domain.model.Score;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScoreService {
    List<Score> getAll();
    Score getById(Long id);
    List<Score> getByDriverId(Long driverId);
    Score create(Score score);
    Score update(Long scoreId,Score request);
    ResponseEntity<?> delete(Long scoreId);

}
