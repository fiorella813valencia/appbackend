package com.example.appbackend.product.resource;

import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResource {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String serialNumber;
    @NotNull
    private MonitoringLevel monitoringLevel;


//    @Enumerated(EnumType.STRING)
//    private MonitoringLevel monitoringLevel;
}
