package com.mauricio.mongo.ex.post_app.service;


import com.mauricio.mongo.ex.post_app.dto.UserRequest;
import com.mauricio.mongo.ex.post_app.dto.UserResponse;
import com.mauricio.mongo.ex.post_app.model.Post;
import com.mauricio.mongo.ex.post_app.model.User;
import com.mauricio.mongo.ex.post_app.repository.UserRepository;
import com.mauricio.mongo.ex.post_app.service.exception.ObjectNotFoundException;
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

    public UserResponse findById(String id){
        return mapperTo.mapToUserResponse(userRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado")));
    }

    public UserResponse insert(UserRequest request){
        User user = new User(null, request.nome(), request.email());
        userRepository.insert(user);
        return mapperTo.mapToUserResponse(user);
    }

    public void delete(String id){
        userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
        userRepository.deleteById(id);
    }

    public UserResponse atualizar(String id, UserRequest request){
        User user = userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));

        if (request.nome() != null){
            user.setNome(request.nome());
        }
        if (request.email() !=null){
            user.setEmail(request.email());
        }
        userRepository.save(user);
        return mapperTo.mapToUserResponse(user);
    }

    public List<Post> findAllPostByAuthorId(String id){
        User user = userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));

        return user.getPosts();

    }
}
