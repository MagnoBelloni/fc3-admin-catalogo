package com.magno.admin.catalogo.application;


import com.magno.admin.catalogo.domain.category.Category;

public class UseCase {
    public Category execute(String name, String description, boolean isActive) {
        return Category.newCategory(name, description, isActive);
    }
}