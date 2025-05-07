package com.example.ORM1.Repository;

import com.example.ORM1.model.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailsRepository extends
        JpaRepository<PersonDetails,Integer> {
}
