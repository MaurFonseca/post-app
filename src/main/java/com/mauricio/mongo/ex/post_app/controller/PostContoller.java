package com.mauricio.mongo.ex.post_app.controller;

import com.mauricio.mongo.ex.post_app.model.Post;
import com.mauricio.mongo.ex.post_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostContoller {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByName(@RequestParam(value = "text", defaultValue = "") String text){
        return ResponseEntity.ok().body(service.findByTitle(text));
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "")String minDate,
            @RequestParam(value = "maxDate", defaultValue = "")String maxDate){
        return ResponseEntity.ok().body(service.fullSearch(text, minDate, maxDate));
    }
}
