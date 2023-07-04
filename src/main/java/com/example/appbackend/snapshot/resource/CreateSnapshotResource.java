package com.example.appbackend.snapshot.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSnapshotResource {
    @NotBlank
    private String snapshotId;
    @NotBlank
    private String productSerialNumber;
    @NotNull
    private Double temperature;
    @NotNull
    private Double energy;
    @NotNull
    private Integer leakage;
}
