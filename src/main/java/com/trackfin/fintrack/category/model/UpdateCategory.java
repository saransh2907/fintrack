package com.trackfin.fintrack.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCategory {
    private String oldCategory;
    private String newCategory;
}
