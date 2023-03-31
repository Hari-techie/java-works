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
    public String saveBook(@ModelAttribute("Book") Book book) {
        System.out.println("save book");
        if (book.getId() == 0) {
            bookDaoImpl.insertBook(book);
        } else {
            bookDaoImpl.updateBook(book);
        }
        return "redirect:/list";
    }

    // @PostMapping("/saveBook")
    // public ResponseEntity<Book> saveBook(@ModelAttribute("book") Book book) {
    // try {
    // if (book.getId() == 0) {
    // bookDaoImpl.insertBook(book);
    // } else {
    // bookDaoImpl.updateBook(book);
    // }
    // return ResponseEntity.ok(book);
    // } catch (Exception e) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }
    // }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
        System.out.println("update " + theId);
        Book Book = bookDaoImpl.getBookById(theId);
        System.out.println(Book);
        theModel.addAttribute("Book", Book);
        return "book-form";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int theId, Model theModel) {
        System.out.println(theId);

        Book book = new Book();
        book.setId(theId);
        bookDaoImpl.deleteBook(book);

        List<Book> theBooks = bookDaoImpl.listBooks();
        theModel.addAttribute("Books", theBooks);
        return "redirect:/list";
    }
}
