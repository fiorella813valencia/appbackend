package com.example.appbackend.product.domain.persistence;

import com.example.appbackend.product.domain.model.Product;
import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
    Product findByMonitoringLevel(MonitoringLevel monitoringLevel);
    Product findBySerialNumber(String serialNumber);


}
