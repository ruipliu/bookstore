package main.dao;

import main.dao.impl.CategoryDaoImpl;
import main.entity.Category;
import org.junit.Test;

import java.util.List;

public class CategoryDaoTest {

    @Test
    public void add() {
        Category category = new Category();
        category.setId("2");
        category.setName("java");
        category.setDescription("Database test.");
        CategoryDaoImpl category1 = new CategoryDaoImpl();
        category1.addCategory(category);
        category1.addCategory(new Category("1", "数据库", "数据库测试"));
    }
    @Test
    public void find() {
        String id = "2";
        CategoryDaoImpl category1 = new CategoryDaoImpl();
        Category category = category1.findCategory(id);
        System.out.println(category.getName());
    }

    @Test
    public void getAll() {
        CategoryDaoImpl category1 = new CategoryDaoImpl();
        List<Category> categories = category1.getAllCategory();
        for (Category category : categories) {
            System.out.println(category.getName());
        }
    }
}
