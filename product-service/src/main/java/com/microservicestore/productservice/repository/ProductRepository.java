package com.microservicestore.productservice.repository;

import com.microservicestore.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Long> {


}
