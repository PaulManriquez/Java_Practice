package com.Main.Repositorys;


import com.Main.Entitys.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job,Integer> {
}
