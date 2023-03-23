package com.kgisl.springxml1.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kgisl.springxml1.model.Book;

@Repository
public class BookDAOjdbc implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Book> listBooks() {
        String SQL = "select * from books";
        List<Book> books = jdbcTemplate.query(SQL, new BookMapper());
        for (Book book : books) {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice());
        }
        return books;
    }

    @Override
    public List<Book> insertBooks(Book book) {
        String SQL = "INSERT INTO books (title, author, price) values (?, ?, ?)";
        jdbcTemplate.update(SQL, book.getTitle(), book.getAuthor(), book.getPrice());
        return listBooks();
    }

    @Override
    public List<Book> deleteBook(Book book) {
        String SQL = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(SQL, book.getId());
        return listBooks();
    }

    @Override
    public List<Book> updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getId());
        return listBooks();
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        List<Book> books = jdbcTemplate.query(sql, ps -> ps.setInt(1, id), new BookMapper());
        if (books.isEmpty()) {
            return null;
        } else {
            return books.get(0);
        }

    }

}