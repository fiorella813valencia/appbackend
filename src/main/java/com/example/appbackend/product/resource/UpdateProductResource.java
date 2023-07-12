package com.example.appbackend.product.resource;

import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResource {
    private Long id;
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
