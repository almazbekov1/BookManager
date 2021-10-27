package com.peaksoft.controller;

import com.peaksoft.model.Book;
import com.peaksoft.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
// /books/add-book
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //localhost:8080/books
    @GetMapping
    public String listBooks(Model model){
        System.out.println("listBooks");
        List<Book> books =  bookService.listBooks();
        model.addAttribute("testBook",books);

        return "books";
    }

    //localhost:8080/books/add-book
    @GetMapping("/add-book")
    public String addBook(Book book){
        return "add-book";
    }

    //localhost:8080/books/save-book
    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book){

        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());
        System.out.println(book.getTitle());



        bookService.addBook(book);


        return "redirect:/books";
    }
}
