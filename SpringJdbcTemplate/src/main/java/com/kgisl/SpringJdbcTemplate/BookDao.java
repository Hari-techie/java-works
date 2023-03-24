package com.kgisl.SpringJdbcTemplate;

import java.util.List;

import javax.sql.DataSource;

public interface BookDao {
    public void setDataSource(DataSource ds);

    public List<Book> listBooks();

    public boolean updateBook(Book book);

    public boolean deleteBook(Book book);

    public boolean insertBook(Book book);

    public Book getBookById(int id);
}
