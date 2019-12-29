package main.dao;

import main.entity.Category;

import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);

    Category findCategory(String id);

    List<Category> getAllCategory();

    void deleteCategory(String id);

    void updateCategory(String id, String name, String description);
}
