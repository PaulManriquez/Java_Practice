package com.Main.Seeder;

import com.Main.Entitys.Category;
import com.Main.Entitys.Job;
import com.Main.Repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<Job> listJobs1 = new ArrayList<>();
            List<Job> listJobs2 = new ArrayList<>();
            // Create Categories
            Category it = new Category();
            it.setName("IT");

            Category marketing = new Category();
            marketing.setName("Marketing");

            // Create Jobs
            Job backend = new Job();
            backend.setTitle("Backend Developer");

            Job frontend = new Job();
            frontend.setTitle("Frontend Developer");

            Job seo = new Job();
            seo.setTitle("SEO Specialist");

            // Link Jobs to Categories
            listJobs1.add(backend);
            listJobs1.add(frontend);
            //it.setJobs(listJobs1);
            it.addJob(backend);
            it.addJob(frontend);

            listJobs2.add(seo);
            //marketing.setJobs(listJobs2);
            marketing.addJob(seo);

            // Save categories (jobs will be saved automatically)
            categoryRepository.saveAll(List.of(it, marketing));

            System.out.println("✔ Sample categories and jobs inserted!");
        }
    }
}
