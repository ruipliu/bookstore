package main.dao;

import main.entity.Book;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);
    public Book findBook(String id);
    public List<Book> getPageData(int start, int end);
    public List<Book> getPageData(int start, int end, String category_id);
    public int getTotalRecord();
    public long getCategoryTotalRecord(String category_id);
}
