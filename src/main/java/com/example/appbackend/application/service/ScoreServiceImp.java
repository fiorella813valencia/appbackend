package com.example.appbackend.application.service;

import com.example.appbackend.application.domain.model.Score;
import com.example.appbackend.application.domain.persistence.ScoreRepository;
import com.example.appbackend.application.domain.service.ScoreService;
import com.example.appbackend.shared.exception.ResourceNotFoundException;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ScoreServiceImp implements ScoreService {

    private static final String ENTITY="Score";
    private final ScoreRepository scoreRepository;
    private final Validator validator;

    public ScoreServiceImp(ScoreRepository scoreRepository, Validator validator){
        this.scoreRepository=scoreRepository;
        this.validator =validator;
    }
    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getById(Long id) {
        return scoreRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public List<Score> getByDriverId(Long driverId) {
        return scoreRepository.findByDriverId(driverId);
    }

    @Override
    public Score create(Score score) {
        score.setRegisteredAt(new Date());
        return scoreRepository.save(score);
    }

    @Override
    public Score update(Long scoreId, Score request) {
        return scoreRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long scoreId) {
        return scoreRepository.findById(scoreId).map(
                score -> {
                    scoreRepository.delete(score);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, scoreId));
    }
}
