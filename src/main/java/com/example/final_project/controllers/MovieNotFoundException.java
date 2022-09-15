package com.example.final_project.controllers;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Could not find movie " + id);
    }
}
