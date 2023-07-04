package com.example.appbackend.application.resource;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateScoreResource {

    @NotNull
    private Long driverId;
    @NotNull
    private Float value;
}
