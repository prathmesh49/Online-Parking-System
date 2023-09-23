package com.example.serviceInterfaces;

import com.example.model.Books;

import java.util.List;

public interface BookService {
    List<Books> getAllBooks();
    Books getBookById(int bookId);
    void addBook(Books book);
    void updateBook(Books book);
    void deleteBook(int bookId);
}
