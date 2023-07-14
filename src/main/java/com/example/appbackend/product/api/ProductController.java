package com.example.appbackend.product.api;

import com.example.appbackend.product.domain.service.ProductService;
import com.example.appbackend.product.mapping.ProductMapper;
import com.example.appbackend.product.resource.CreateProductResource;
import com.example.appbackend.product.resource.ProductResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public final ProductService productService;
    private final ProductMapper mapper;

    public ProductController(ProductService productService, ProductMapper mapper){
        this.productService=productService;
        this.mapper=mapper;
    }

    //GET ALL
    @GetMapping
    public List<ProductResource> getAllProducts(){
        return mapper.modelList(productService.getAll());
    }
    //GET BY ID
    @GetMapping("{productId}")
    public ProductResource getProductById(@PathVariable Long productId){
        return mapper.toResource(productService.getById(productId));
    }
    //POST
    @PostMapping
    public ProductResource createProduct(@RequestBody CreateProductResource resource){
        return mapper.toResource(productService.create(mapper.toModel(resource)));
    }

    //DELETE
    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productService.delete(productId);
    }
}
