package com.mauricio.mongo.ex.post_app.repository;

import com.mauricio.mongo.ex.post_app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
