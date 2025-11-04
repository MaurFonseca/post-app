package com.mauricio.mongo.ex.post_app.model;

import com.mauricio.mongo.ex.post_app.dto.AuthorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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

    private AuthorDto author;
}
