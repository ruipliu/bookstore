package main.dao.impl;

import main.dao.CategoryDao;
import main.entity.Category;
import main.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    public void addCategory(Category category) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "insert into category (id, name, description) values(?,?,?)";
        try {
            queryRunner.update(sql, new Object[]{category.getId(), category.getName(), category.getDescription()});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Category findCategory(String id) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from category where id=" + id;
        try {
            Category category = (Category) queryRunner.query(sql, new BeanHandler(Category.class));
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> getAllCategory() {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from category";

        try {
            List<Category> categories = (List<Category>) queryRunner.query(sql, new BeanListHandler(Category.class));
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCategory(String id) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "delete * from category where id=" + id;

        try {
            queryRunner.update(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCategory(String id, String name, String description) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "update * from category set name = ?, description = ? where id = ?";
        Object[] params = {name, description, id};

        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
