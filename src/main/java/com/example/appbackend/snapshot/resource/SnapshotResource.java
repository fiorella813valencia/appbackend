package com.example.appbackend.snapshot.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SnapshotResource {


    private Long id;
    private String snapshotId;
    private String productSerialNumber;
    private Double temperature;
    private Double energy;
    private Integer leakage;
}
