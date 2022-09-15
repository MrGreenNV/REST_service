package com.example.final_project.controllers;

public class DirectorNotFoundException extends RuntimeException {
    public DirectorNotFoundException(Long id) {
        super("Could not find user" + id);
    }
}
