package com.mauricio.mongo.ex.post_app.dto;

import java.time.LocalDate;

public record CommentsDTO(AuthorDto author, String text, LocalDate date) {
}
