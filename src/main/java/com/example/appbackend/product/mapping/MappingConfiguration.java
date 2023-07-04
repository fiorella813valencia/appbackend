package com.example.appbackend.product.mapping;

import org.springframework.context.annotation.Bean;

public class MappingConfiguration {
    @Bean
    public ProductMapper productMapper(){
        return new ProductMapper();
    }
}
