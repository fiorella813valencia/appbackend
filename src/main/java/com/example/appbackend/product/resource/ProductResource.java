package com.example.appbackend.product.resource;

import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
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
