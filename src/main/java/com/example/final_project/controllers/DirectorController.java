package com.example.final_project.controllers;

import com.example.final_project.models.Director;
import com.example.final_project.repositories.DirectorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class DirectorController {
    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping("/directors")
    Iterable<Director> all(){
        return directorRepository.findAll();
    }

    @PostMapping("/directors")
    Director newDirector(@RequestBody Director newDirector) {
        return directorRepository.save(newDirector);
    }

    @GetMapping("/directors/{id}")
    Director one(@PathVariable Long id) {
        return directorRepository.findById(id)
                .orElseThrow(() -> new DirectorNotFoundException(id));
    }

    @DeleteMapping("/directors/{id}")
    void deleteDirector(@PathVariable Long id) {
        directorRepository.deleteById(id);
    }
}
