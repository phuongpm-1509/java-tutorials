package com.example.spring_jpa_core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_jpa_core.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.spring_jpa_core.model.Book;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String title) {
        return bookService.getAllBooks(title);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookDetail(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PatchMapping("/{id}/update")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}/")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
