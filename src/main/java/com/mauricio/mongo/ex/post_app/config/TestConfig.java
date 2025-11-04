package com.mauricio.mongo.ex.post_app.config;

import com.mauricio.mongo.ex.post_app.dto.AuthorDto;
import com.mauricio.mongo.ex.post_app.model.Post;
import com.mauricio.mongo.ex.post_app.model.User;
import com.mauricio.mongo.ex.post_app.repository.PostRepository;
import com.mauricio.mongo.ex.post_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User mauricio = new User(null, "Mauricio Zazeri", "mauricio@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, mauricio));

        Post p1 = new Post(null, LocalDate.now(), "Passei no AGI!!", "Feliz em anunciar que passei no programa de devs do agi!", new AuthorDto(mauricio.getId(), mauricio.getNome()));

        postRepository.save(p1);

        mauricio.getPosts().add(p1);
        userRepository.save(mauricio);
    }
}
