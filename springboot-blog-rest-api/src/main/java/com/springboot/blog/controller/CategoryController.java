package com.springboot.blog.controller;

import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.getCategory(id);
        return ResponseEntity.ok(categoryDto);
    }
}
