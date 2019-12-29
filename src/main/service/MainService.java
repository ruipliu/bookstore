package main.service;

import main.entity.Category;

import java.util.List;

public interface MainService {
    void addCategory(Category category);

    List<Category> getAllCategory();

    void deleteCategory(String id);

    void updateCategory(String id, String name, String description);
}
