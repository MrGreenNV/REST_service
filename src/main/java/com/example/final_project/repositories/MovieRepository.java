package com.example.final_project.repositories;

import com.example.final_project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository {
    Optional<Movie> findById(long id);
}
