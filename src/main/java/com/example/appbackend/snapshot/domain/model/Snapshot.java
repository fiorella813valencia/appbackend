package com.example.appbackend.snapshot.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="snapshot")
public class Snapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
