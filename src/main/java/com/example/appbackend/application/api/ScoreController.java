package com.example.appbackend.application.api;

import com.example.appbackend.application.domain.model.Scope;
import com.example.appbackend.application.domain.service.ScoreService;
import com.example.appbackend.application.mapping.ScoreMapper;
import com.example.appbackend.application.resource.CreateScoreResource;
import com.example.appbackend.application.resource.ScoreResource;
import com.example.appbackend.application.resource.UpdateScoreResource;
import com.example.appbackend.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/v1/drivers")
public class ScoreController {
    public final ScoreService scoreService;
    private final ScoreMapper mapper;

    public ScoreController(ScoreService scoreService, ScoreMapper mapper){
        this.scoreService=scoreService;
        this.mapper=mapper;
    }
    //GET Scope
    @GetMapping("/{driverId}/scores/{scope}")
    public ResponseEntity<Scope> getDriverScores(@PathVariable Long driverId, @PathVariable Integer scope){
        Scope value=new Scope();
        if(scope==0){
            value =scoreService.getMax(driverId);
        }else if(scope==1){
            value=scoreService.getAverage(driverId);
        }else
            throw new ResourceNotFoundException("Scope value not specified");
        return ResponseEntity.ok(value);
    }
    //GET ALL
    @GetMapping
    public List<ScoreResource> getAllAdmins(){
        return mapper.modelList(scoreService.getAll());
    }
    //GET BY ID
    @GetMapping("{driverId}/scores")
    public List<ScoreResource> getScoreByDriverId(@PathVariable Long driverId){
        return mapper.modelList(scoreService.getByDriverId(driverId));
    }
    //POST
    @PostMapping
    public ScoreResource createScore(@RequestBody CreateScoreResource resource){
        return mapper.toResource(scoreService.create(mapper.toModel(resource)));
    }
    //UPDATE
    @PutMapping("/{scoreId}")
    public ScoreResource updateScore(@PathVariable Long scoreId, @RequestBody UpdateScoreResource resource) {
        return mapper.toResource(scoreService.update(scoreId, mapper.toModel(resource)));
    }

    //DELETE
    @DeleteMapping("{scoreId}")
    public ResponseEntity<?> deleteScore(@PathVariable Long scoreId) {
        return scoreService.delete(scoreId);
    }
}
