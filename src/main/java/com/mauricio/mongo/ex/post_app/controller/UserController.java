package com.mauricio.mongo.ex.post_app.controller;

import com.mauricio.mongo.ex.post_app.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User u1 = new User("1", "Mauricio", "maur@gmail.com");
        User u2 = new User("2", "Ana", "ana@gmail.com");
        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(u1, u2));
        return ResponseEntity.ok().body(list);
    }
}
