package com.example.appbackend.application.domain.persistence;

import com.example.appbackend.application.domain.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAll();
    List<Score> findByDriverId(Long driverId);
    Score findByValue(Float value);
}
