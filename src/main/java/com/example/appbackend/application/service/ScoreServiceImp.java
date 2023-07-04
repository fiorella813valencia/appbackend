package com.example.appbackend.application.service;

import com.example.appbackend.application.domain.model.Scope;
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

    @Override
    public Scope getMax(Long driverId) {
        List<Score> scores=scoreRepository.findByDriverId(driverId);
        if(scores.isEmpty())
            throw new ResourceNotFoundException(ENTITY,driverId);

        float max = 0;
        for (Score score:scores){
            if(max<score.getValue())
                max=score.getValue();
        }

        Scope scope=new Scope();
        scope.setValue(max);
        scope.setDriverId(driverId);
        return scope;
    }

    @Override
    public Scope getAverage(Long driverId) {
        List<Score> scores=scoreRepository.findByDriverId(driverId);
        if(scores.isEmpty())
            throw new ResourceNotFoundException(ENTITY,driverId);

        float suma = 0;
        for (Score score:scores){
            suma=suma+score.getValue();
        }
        float average=0;
        average=suma/scores.size();

        Scope scope =new Scope();
        scope.setValue(average);
        scope.setDriverId(driverId);
        return scope;
    }
}
