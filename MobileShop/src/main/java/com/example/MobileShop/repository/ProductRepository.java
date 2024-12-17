package com.example.MobileShop.repository;

import com.example.MobileShop.model.product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<product, String> {
}
