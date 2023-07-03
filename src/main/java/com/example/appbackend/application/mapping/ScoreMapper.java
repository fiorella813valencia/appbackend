package com.example.appbackend.application.mapping;

import com.example.appbackend.application.domain.model.Score;
import com.example.appbackend.application.resource.CreateScoreResource;
import com.example.appbackend.application.resource.ScoreResource;
import com.example.appbackend.application.resource.UpdateScoreResource;
import com.example.appbackend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@EnableAutoConfiguration
public class ScoreMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ScoreResource toResource(Score model){
        return mapper.map(model, ScoreResource.class);
    }


    public Page<ScoreResource> modelListPage(List<Score> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ScoreResource.class),pageable,modelList.size());
    }

    public List<ScoreResource> modelList(List<Score> modelList){
        return mapper.mapList(modelList,ScoreResource.class);
    }


    public Score toModel(CreateScoreResource resource){
        return mapper.map(resource,Score.class);

    }

    public Score toModel(UpdateScoreResource resource){
        return mapper.map(resource,Score.class);
    }
}
