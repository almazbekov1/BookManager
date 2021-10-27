package com.peaksoft.service;

import com.peaksoft.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> listBooks();
}
