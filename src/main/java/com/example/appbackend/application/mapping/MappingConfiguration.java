package com.example.appbackend.application.mapping;

import org.springframework.context.annotation.Bean;

public class MappingConfiguration {

    @Bean
    public ScoreMapper scoreMapper(){
        return new ScoreMapper();
    }
}
