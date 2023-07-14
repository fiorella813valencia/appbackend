package com.example.appbackend.snapshot.service;

import com.example.appbackend.product.domain.model.Product;
import com.example.appbackend.product.domain.model.enums.MonitoringLevel;
import com.example.appbackend.product.domain.persistence.ProductRepository;
import com.example.appbackend.product.domain.service.ProductService;
import com.example.appbackend.shared.exception.ResourceNotFoundException;
import com.example.appbackend.shared.exception.ResourceValidationException;
import com.example.appbackend.snapshot.domain.model.Snapshot;
import com.example.appbackend.snapshot.domain.persistence.SnapshotRepository;
import com.example.appbackend.snapshot.domain.service.SnapshotService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SnapshotServiceImp implements SnapshotService {

    private static final String ENTITY="Snapshot";
    private final SnapshotRepository snapshotRepository;
    private final Validator validator;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public SnapshotServiceImp(SnapshotRepository snapshotRepository, Validator validator,ProductService productService, ProductRepository productRepository){
        this.snapshotRepository=snapshotRepository;
        this.validator =validator;
        this.productService=productService;
        this.productRepository=productRepository;

    }
    @Override
    public List<Snapshot> getAll() {
        return snapshotRepository.findAll();
    }

    @Override
    public Snapshot getById(Long snapshotId) {
        return snapshotRepository.findById(snapshotId).orElseThrow(()->new ResourceNotFoundException(ENTITY,snapshotId));
    }

    @Override
    public Snapshot create(Snapshot snapshot) {
        Set<ConstraintViolation<Snapshot>> violations = validator.validate(snapshot);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        Snapshot snapshotWithSnapshotId=snapshotRepository.findBySnapshotId(snapshot.getSnapshotId());
        if(snapshotWithSnapshotId!=null)
            throw new ResourceValidationException(ENTITY,"Snapshot with the same snapshotId number already exists");

        if(!(snapshot.getLeakage()==0||snapshot.getLeakage()==1))
            throw new ResourceValidationException(ENTITY,"Leakage must be 0 or 1");

        return snapshotRepository.save(snapshot);
    }

//    @Override
//    public Snapshot create(Snapshot snapshot, Long productId) {
//        Set<ConstraintViolation<Snapshot>> violations = validator.validate(snapshot);
//        if(!violations.isEmpty())
//            throw new ResourceValidationException(ENTITY,violations);
//
//        Optional<Product> existingProduct=productRepository.findById(productId);
//        if(existingProduct.isPresent()){
//            Product existingProduct_ = existingProduct.get();
//            if(existingProduct_.getMonitoringLevel()== MonitoringLevel.ADVANCE_MONITORING){
//                Snapshot snapshotWithSnapshotId=snapshotRepository.findBySnapshotId(snapshot.getSnapshotId());
//                if(snapshotWithSnapshotId!=null)
//                    throw new ResourceValidationException(ENTITY,"Snapshot with the same snapshotId number already exists");
//
//                if(!(snapshot.getLeakage()==0||snapshot.getLeakage()==1))
//                    throw new ResourceValidationException(ENTITY,"Leakage must be 0 or 1");
//
//                return snapshotRepository.save(snapshot);
//            }else {
//                throw new ResourceValidationException("Product should be advanced level");
//            }
//
//        }else{
//            throw new ResourceNotFoundException("There is not any product with that Id");
//        }
//    }

    @Override
    public Snapshot update(Long snapshotId, Snapshot request) {
        return snapshotRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long snapshotId) {
        return snapshotRepository.findById(snapshotId).map(
                snapshot -> {
                    snapshotRepository.delete(snapshot);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, snapshotId));
    }

    @Override
    public List<Snapshot> getSnapshotsByProductId(Long productId) {
        Product product = productService.getById(productId);
        return snapshotRepository.findByProductSerialNumber(product.getSerialNumber());
    }
}
