package com.example.appbackend.application.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ScoreResource {

    private Long id;
    private Long driverId;
    private Float value;
    private Date registeredAt;
}
