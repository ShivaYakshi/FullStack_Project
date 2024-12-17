package com.example.MobileShop.repository;

import com.example.MobileShop.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
