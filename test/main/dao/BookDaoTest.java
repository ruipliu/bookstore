package main.dao;

import main.dao.impl.BookDaoImpl;
import main.entity.Book;
import org.junit.Test;

public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void add() {
        Book book = new Book();
        book.setId("5");
        book.setName("SQLServer");
        book.setAuthor("我也不知道");
        book.setImage("33333332432");
        book.setPrice(33.22);
        book.setDescription("这是一本好书");
        book.setCategory_id("0bf0d4dd-8f84-4d5e-97de-6a88f3d2f482");

        bookDao.addBook(book);
    }
}
