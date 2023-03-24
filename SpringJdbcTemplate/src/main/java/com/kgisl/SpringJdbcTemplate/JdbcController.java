package com.kgisl.SpringJdbcTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class JdbcController {

    @Autowired
    private BookDao bookDaoImpl;

    @GetMapping("/")
    public String showHome() {
        return "index";
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {
        List<Book> theBooks = bookDaoImpl.listBooks();
        theModel.addAttribute("Books", theBooks);
        return "list-book";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Book theBook = new Book();
        theModel.addAttribute("Book", theBook);
        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveCustomer(@ModelAttribute("book") Book book) {
        bookDaoImpl.insertBook(book);
        return "redirect:/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("BookId") int theId,
            Model theModel) {
        Book theBook = bookDaoImpl.getBookById(theId);

        theModel.addAttribute("Book", theBook);
        return "book-form";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("BookId") int theId, Model theModel) {
        Book book = new Book();
        book.setId(theId);
        bookDaoImpl.deleteBook(book);

        List<Book> theBooks = bookDaoImpl.listBooks();
        theModel.addAttribute("Books", theBooks);
        return "redirect:/list";
    }
}
