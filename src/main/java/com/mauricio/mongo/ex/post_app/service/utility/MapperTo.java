package com.mauricio.mongo.ex.post_app.service.utility;

import com.mauricio.mongo.ex.post_app.dto.UserResponse;
import com.mauricio.mongo.ex.post_app.model.User;
import org.springframework.stereotype.Component;

@Component
public class MapperTo {


    public UserResponse mapToUserResponse(User user){
        return new UserResponse(user.getId(), user.getNome(), user.getEmail());
    }
}
