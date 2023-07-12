package com.example.appbackend.product.resource;

import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ProductResource {
    private Long id;
    private String brand;
    private String model;
    private String serialNumber;
    private MonitoringLevel monitoringLevel;

}
