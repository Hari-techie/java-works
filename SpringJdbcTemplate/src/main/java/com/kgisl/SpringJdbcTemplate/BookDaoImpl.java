package com.kgisl.SpringJdbcTemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        // TODO Auto-generated method stub
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> listBooks() {
        // TODO Auto-generated method stub
        String SQL = "select * from books";
        List<Book> books = jdbcTemplateObject.query(
                SQL, new BookMapper());

        return books;
    }

    @Override
    public boolean updateBook(Book book) {
        // TODO Auto-generated method stub
        String SQL = "update books set title = ?, author = ?, price  = ?, qty = ? where id = ?";
        return jdbcTemplateObject.update(SQL, book.getTitle(), book.getAuthor(), book.getPrice(), book.getQty(),
                book.getId()) > 0;
    }

    @Override
    public boolean deleteBook(Book book) {
        // TODO Auto-generated method stub
        String SQL = "delete from books where id = ?";
        return jdbcTemplateObject.update(SQL, book.getId()) > 0;
    }

    @Override
    public boolean insertBook(Book book) {
        // TODO Auto-generated method stub
        String SQL = "insert into books(title, author, price, qty) values(?,?,?,?)";
        return jdbcTemplateObject.update(SQL, book.getTitle(), book.getAuthor(), book.getPrice(), book.getQty()) > 0;
    }

    @Override
    public Book getBookById(int bid) {
        String SQL = "select * from books where id = ?";
        List<Book> books = listBooks();
        for (Book book : books) {
            if (book.getId() == bid) {
                return book;
            }
        }
        return null;
    }

}
