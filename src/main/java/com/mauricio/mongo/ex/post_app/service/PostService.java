package com.mauricio.mongo.ex.post_app.service;

import com.mauricio.mongo.ex.post_app.model.Post;
import com.mauricio.mongo.ex.post_app.repository.PostRepository;
import com.mauricio.mongo.ex.post_app.service.exception.ObjectNotFoundException;
import com.mauricio.mongo.ex.post_app.service.utility.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        text = URL.decode(text);

        return repo.searchByTitle(text);
    }

    public List<Post> fullSearch(String text, String minDate, String maxDate){
        text = URL.decode(text);
        Instant min = URL.decodeData(minDate, LocalDate.of(1970, 1, 1)).atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant max = URL.decodeData(maxDate, LocalDate.now()).plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();

        return repo.fullSearch(text, min, max);
    }
}
