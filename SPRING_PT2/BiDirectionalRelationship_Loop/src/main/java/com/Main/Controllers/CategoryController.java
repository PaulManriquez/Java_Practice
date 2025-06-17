package com.Main.Controllers;

import com.Main.Entitys.Category;
import com.Main.Entitys.Job;
import com.Main.Repositorys.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Categories", description = "Operations for managing job categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Operation(summary = "Get all categories", description = "Returns a list of all categories with their associated jobs.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved categories")
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Operation(summary = "Create a new category", description = "Creates a new job category and optionally its jobs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        if (category.getJobs() != null) {
            for (Job job : category.getJobs()) {
                job.setCategory(category);
            }
        }
        Category saved = categoryRepository.save(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
