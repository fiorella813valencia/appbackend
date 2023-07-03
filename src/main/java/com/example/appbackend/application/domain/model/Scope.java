package com.example.appbackend.application.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class Scope {
    private Float value;
}
