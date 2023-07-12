package com.example.appbackend.product.domain.model;

import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
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
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String serialNumber;
//    @NotNull
//    private Integer monitoringLevel;
    @NotNull
    private MonitoringLevel monitoringLevel;


}
