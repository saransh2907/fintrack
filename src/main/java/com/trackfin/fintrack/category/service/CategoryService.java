package com.trackfin.fintrack.category.service;

import com.trackfin.fintrack.category.entity.Category;
import com.trackfin.fintrack.category.model.UpdateCategory;
import com.trackfin.fintrack.category.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo repo;
    public List<Category> getAllCategories() {
        return repo.findByIsActiveTrue();
    }

    public Category addNewCategory(String newCategory){
        Optional<Category> cat = repo.findByName(newCategory);
        if(cat.isPresent()){
            Category updatedCategory = cat.get();
            updatedCategory.setIsActive(true);
            updatedCategory = repo.save(updatedCategory);
            return updatedCategory;
        }
        Category category = new Category(null, newCategory, true);
        return repo.save(category);
    }

    public Category updateCategory(UpdateCategory uCategory) {
        Optional<Category> categoryOptional = repo.findByName(uCategory.getOldCategory());
        if(categoryOptional.isPresent() && categoryOptional.get().getIsActive()){
            Optional<Category> newCategoryOptional = repo.findByName(uCategory.getNewCategory());
            if(newCategoryOptional.isEmpty()) {
                Category updatedCategory = categoryOptional.get();
                updatedCategory.setName(uCategory.getNewCategory());
                return repo.save(updatedCategory);
            }
        }
        return null;
    }

    public boolean deleteCategory(String category) {
        Optional<Category> cat = repo.findByName(category);
        if(cat.isPresent()){
//            repo.delete(cat.get());
            Category update = cat.get();
            update.setIsActive(false);
            repo.save(update);
            return true;
        }
        return false;
    }
}
