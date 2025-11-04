package com.mauricio.mongo.ex.post_app.service;


import com.mauricio.mongo.ex.post_app.dto.UserResponse;
import com.mauricio.mongo.ex.post_app.model.User;
import com.mauricio.mongo.ex.post_app.repository.UserRepository;
import com.mauricio.mongo.ex.post_app.service.utility.MapperTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperTo mapperTo;

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream().map(x -> mapperTo.mapToUserResponse(x)).toList();
    }
}
