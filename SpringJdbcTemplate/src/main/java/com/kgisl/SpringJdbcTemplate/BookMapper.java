package com.kgisl.SpringJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class BookMapper implements RowMapper<Book> {
    
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));   // id to be set here to reflect in front
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getFloat("price"));
        book.setQty(rs.getInt("qty"));
        return book;
    }
}

