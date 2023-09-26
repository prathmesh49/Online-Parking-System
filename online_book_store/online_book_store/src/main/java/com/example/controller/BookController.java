package com.example.controller;

import com.example.model.Books;
import com.example.serviceInterfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/browse")
    public ResponseEntity<List<Books>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Books> getBookById(@PathVariable int bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @PostMapping("/")
    public ResponseEntity<String> addBook(@RequestBody Books books){
        bookService.addBook(books);
        return ResponseEntity.ok("added successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateBook(@RequestBody Books books){
        bookService.updateBook(books);
        return ResponseEntity.ok("Updated successfully");
    }
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Deleted successfully");
    }

}
