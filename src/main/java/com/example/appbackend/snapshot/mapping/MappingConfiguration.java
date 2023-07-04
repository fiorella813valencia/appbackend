package com.example.appbackend.snapshot.mapping;

import org.springframework.context.annotation.Bean;

public class MappingConfiguration {

    @Bean
    public SnapshotMapper snapshotMapper(){
        return new SnapshotMapper();
    }
}
