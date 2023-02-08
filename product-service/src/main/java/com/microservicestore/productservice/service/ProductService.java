package com.microservicestore.productservice.service;

import com.microservicestore.productservice.dto.ProductRequest;
import com.microservicestore.productservice.dto.ProductResponse;
import com.microservicestore.productservice.model.Product;
import com.microservicestore.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product1=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product1);

        log.info("A new product has been created ");
    }


    public List<ProductResponse>getAllProducts(){
        List<ProductResponse>productResponseList= productRepository.findAll().stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
        log.info("Products has been collected");
        return productResponseList;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();

    }


}
