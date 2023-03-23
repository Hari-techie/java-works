package com.kgisl.springxml1.dao;

import java.util.List;

import javax.sql.DataSource;

import com.kgisl.springxml1.model.Book;

public interface BookDAO {
    public void setDataSource(DataSource ds);

    // Used to list down all the records
    // from the Student table
    public List<Book> listBooks();
    public List<Book> insertBooks(Book book);
    public List<Book> deleteBook(Book book);
    public List<Book> updateBook(Book book);
    public Book getBookById(int id);
}
