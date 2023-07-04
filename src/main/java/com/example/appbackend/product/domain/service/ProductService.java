package com.example.appbackend.product.domain.service;

import com.example.appbackend.application.domain.model.Score;
import com.example.appbackend.product.domain.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getById(Long productId);
    Product create(Product product);
    Product update(Long productId,Product request);
    ResponseEntity<?> delete(Long productId);
}
