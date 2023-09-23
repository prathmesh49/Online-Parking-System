package com.example.service;

import com.example.model.Books;
import com.example.repository.BooksRepository;
import com.example.serviceInterfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private BooksRepository bookRepository;

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books getBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void addBook(Books book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Books book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
