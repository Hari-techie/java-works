package com.kgisl.springxml1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgisl.springxml1.dao.BookDAO;
import com.kgisl.springxml1.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @RequestMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookDAO.listBooks();
        // for (Book book : books) {
        //     System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice());
        // }
        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertBook(@ModelAttribute("book") Book book) {
        bookDAO.insertBooks(book);
        return "redirect:/book/books";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) {
        Book book = new Book();
        book.setId(id);

        bookDAO.deleteBook(book);
        List<Book> books = bookDAO.listBooks();
        model.addAttribute("books", books);

        return "books";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Book book = bookDAO.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "updateBook";
        } else {
            return "redirect:/book/books";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") Book book) {
        bookDAO.updateBook(book);
        return "redirect:/book/books";
    }

}
