package com.mauricio.mongo.ex.post_app.repository;

import com.mauricio.mongo.ex.post_app.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);


    @Query("{ 'title': {$regex: ?0, $options: 'i'} }")
    List<Post> searchByTitle(String text);

    @Query("{$and: [ "
            + "{ 'date': { '$gte': ?1 } }, "
            + "{ 'date': { '$lte': ?2 } }, "
            + "{ $or: [ "
            + "  { 'title': { $regex: ?0, $options: 'i' } }, "
            + "  { 'body': { $regex: ?0, $options: 'i' } }, "
            + "  { 'comments.text': { $regex: ?0, $options: 'i' } } "
            + "] } "
            + "]}")
    List<Post> fullSearch(String text, Instant minDate, Instant maxDate);
}
