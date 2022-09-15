package com.example.final_project.repositories;

import com.example.final_project.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository {
    Optional<Director> findByFirstName(String firstName);
}
