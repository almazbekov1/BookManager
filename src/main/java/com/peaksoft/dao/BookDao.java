package com.peaksoft.dao;

import com.peaksoft.model.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    List<Book> listBooks();
}
