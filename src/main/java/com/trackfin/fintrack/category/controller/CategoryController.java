package com.trackfin.fintrack.category.controller;

import com.trackfin.fintrack.category.entity.Category;
import com.trackfin.fintrack.category.model.UpdateCategory;
import com.trackfin.fintrack.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<String> getAllCategory(){
        return service.getAllCategories().stream().map(Category::getName).collect(Collectors.toList());
    }

    @PostMapping(value = "/add", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Category> addNewCategory(@RequestBody String newCategory){
        System.out.println("Adding new Category "+ newCategory);
        if(newCategory == null){
            return ResponseEntity.status(400).build();
        }
        Category category = service.addNewCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> addNewCategory(@RequestBody UpdateCategory updateCategory){
        Category category = service.updateCategory(updateCategory);
        if(category == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody String category){
        boolean deleted = service.deleteCategory(category);
        if(deleted){
            return ResponseEntity.ok(category +" is deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
