package com.example.appbackend.application.resource;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateScoreResource {
    private Long id;
    @NotNull
    private Long driverId;
    @NotNull
    private Float value;

}
