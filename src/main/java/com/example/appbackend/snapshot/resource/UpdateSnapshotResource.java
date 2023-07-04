package com.example.appbackend.snapshot.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSnapshotResource {
    private Long id;

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
