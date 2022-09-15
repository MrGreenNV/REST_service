package com.example.final_project.controllers;

import com.example.final_project.models.Movie;
import com.example.final_project.repositories.DirectorRepository;
import com.example.final_project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    Iterable<Movie> all(){
        return movieRepository.findAll();
    }

    @PostMapping("/directors/{id}/movies")
    Movie createMovie(@PathVariable (value = "id") Long id,
                      @RequestBody Movie movie) {
        return directorRepository.findById(id).map(director -> {
            movie.setDirector(director);
            return movieRepository.save(movie);
        }).orElseThrow(() -> new DirectorNotFoundException(id));
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
