package com.mauricio.mongo.ex.post_app.controller;

import com.mauricio.mongo.ex.post_app.dto.UserRequest;
import com.mauricio.mongo.ex.post_app.dto.UserResponse;
import com.mauricio.mongo.ex.post_app.model.User;
import com.mauricio.mongo.ex.post_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.UriBuilderFactoryArgumentResolver;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        List<UserResponse> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> insert(@RequestBody UserRequest request){
        URI uri = UriComponentsBuilder.fromPath("").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(userService.insert(request));
    }
}
