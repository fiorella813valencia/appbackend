package com.example.appbackend.product.service;

import com.example.appbackend.product.domain.model.Product;
import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
import com.example.appbackend.product.domain.persistence.ProductRepository;
import com.example.appbackend.product.domain.service.ProductService;
import com.example.appbackend.shared.exception.ResourceNotFoundException;
import com.example.appbackend.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImp implements ProductService {

    private static final String ENTITY="Product";
    private final ProductRepository productRepository;
    private final Validator validator;

    public ProductServiceImp(ProductRepository productRepository, Validator validator){
        this.productRepository=productRepository;
        this.validator =validator;
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
//    public Product getById(Long productId) {
//        return productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException(ENTITY,productId));
//    }
    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));
    }




    @Override
    public Product create(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        Product productWithSerialNumber=productRepository.findBySerialNumber(product.getSerialNumber());
        if(productWithSerialNumber!=null)
            throw new ResourceValidationException(ENTITY,"Product with the same serial number already exists");

//        if(!(product.getMonitoringLevel()==1||product.getMonitoringLevel()==2))
//            throw new ResourceValidationException(ENTITY,"Monitoring level must be 1 or 2");

        if (product.getMonitoringLevel() != MonitoringLevel.ESSENTIAL_MONITORING && product.getMonitoringLevel() != MonitoringLevel.ADVANCE_MONITORING) {
            throw new ResourceValidationException(ENTITY, "Monitoring level must be ESSENTIAL_MONITORING or ADVANCE_MONITORING");
        }



        return productRepository.save(product);
    }

    @Override
    public Product update(Long productId, Product request) {
        return productRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long productId) {
        return productRepository.findById(productId).map(
                product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));

    }
}
