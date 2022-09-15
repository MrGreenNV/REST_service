package com.example.final_project.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DirectorNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DirectorNotFoundException.class)
    @ResponseStatus
    String directorNotFoundHandler(DirectorNotFoundException ex) {
        return ex.getMessage();
    }
}
