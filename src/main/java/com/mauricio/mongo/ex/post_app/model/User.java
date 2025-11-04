package com.mauricio.mongo.ex.post_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String nome;

    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
