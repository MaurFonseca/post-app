package com.mauricio.mongo.ex.post_app.model;

import com.mauricio.mongo.ex.post_app.dto.AuthorDto;
import com.mauricio.mongo.ex.post_app.dto.CommentsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    private String id;

    private LocalDate date;

    private String title;

    private String body;

    public Post(String id, LocalDate date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    private AuthorDto author;

    private List<CommentsDTO> comments = new ArrayList<>();

}
