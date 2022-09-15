package com.example.final_project.controllers;

import com.example.final_project.models.Movie;
import com.example.final_project.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    Iterable<Movie> all(){
        return movieRepository.findAll();
    }

    @PostMapping("/movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}
