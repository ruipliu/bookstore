package main.dao.impl;

import main.dao.BookDao;
import main.entity.Book;
import main.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void addBook(Book book) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO book (id,name,description,author,price,image,category_id) VALUES(?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql, book.getId(), book.getName(), book.getDescription(), book.getAuthor(),
                    book.getPrice(), book.getImage(), book.getCategory_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBook(String id) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "SELECT * FROM book WHERE id=" + id;

        try {
            return (Book) queryRunner.query(sql, new BeanHandler(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getPageData(int start, int end) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM book limit ?,?";
        try {
            return (List<Book>) queryRunner.query(sql, new BeanListHandler(Book.class), new Object[]{start, end});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getPageData(int start, int end, String category_id) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        //WHERE字句在limit字句的前边，注意Object[]的参数位置！
        String sql = "SELECT * FROM book WHERE category_id=? limit ?,?";
        try {
            return (List<Book>) queryRunner.query(sql, new BeanListHandler(Book.class), new Object[]{category_id,start, end});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalRecord() {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "SELECT COUNT(*) FROM book";

        try {
            return (int) queryRunner.query(sql, new ScalarHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long getCategoryTotalRecord(String category_id) {
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

            String sql = "SELECT COUNT(*) FROM book WHERE category_id=?" + category_id;
            return (long) queryRunner.query(sql, new ScalarHandler());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
