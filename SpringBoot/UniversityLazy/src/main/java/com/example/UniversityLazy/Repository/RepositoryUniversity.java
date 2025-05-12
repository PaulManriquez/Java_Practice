package com.example.UniversityLazy.Repository;

import com.example.UniversityLazy.Model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryUniversity extends JpaRepository<University,Integer> {

    // Finds universities with IDs between two values (inclusive)
    List<University> findByIdBetween(Integer startId, Integer endId);

    // Find universities where the ID is in a list of IDs
    List<University> findByIdIn(List<Integer> ids);
}
