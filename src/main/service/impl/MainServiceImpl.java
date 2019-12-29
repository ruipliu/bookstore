package main.service.impl;

import main.dao.BookDao;
import main.dao.CategoryDao;
import main.dao.impl.BookDaoImpl;
import main.dao.impl.CategoryDaoImpl;
import main.entity.Book;
import main.entity.Category;
import main.entity.Page;
import main.service.MainService;

import java.util.List;

public class MainServiceImpl implements MainService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public void deleteCategory(String id) {
        categoryDao.deleteCategory(id);
    }
    @Override
    public void updateCategory(String id, String name, String description) {
        categoryDao.updateCategory(id, name, description);
    }

    /*添加图书*/
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    /*查找图书*/
    public Book findBook(String id) {
        return bookDao.findBook(id);
    }

    /*获取图书的分页数据*/
    public Page getPageData(String pageNum) {

        Page page=null;
        if (pageNum == null) {
            page = new Page(1, bookDao.getTotalRecord());
        } else {
            page = new Page(Integer.valueOf(pageNum), bookDao.getTotalRecord());
        }

        List<Book> books = bookDao.getPageData(page.getStartIndex(), page.getLinesize());
        page.setList(books);

        return page;

    }

    /*获取图书分类后的分页数据*/
    public Page getPageData(String currentPageCount,String category_id) {

        Page page=null;
        if (currentPageCount == null) {
            page = new Page(1, bookDao.getCategoryTotalRecord(category_id));
        } else {
            page = new Page(Integer.valueOf(currentPageCount), bookDao.getCategoryTotalRecord(category_id));
        }

        List<Book> books = bookDao.getPageData(page.getStartIndex(), page.getLinesize(), category_id);
        page.setList(books);
        return page;

    }
}
