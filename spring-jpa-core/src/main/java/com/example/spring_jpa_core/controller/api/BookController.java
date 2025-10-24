package com.example.spring_jpa_core.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_jpa_core.service.BookService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import com.example.spring_jpa_core.dto.book.CreateBookDTO;
import com.example.spring_jpa_core.dto.book.UpdateBookDTO;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.spring_jpa_core.model.Book;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/books")
@Validated
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
    public Book getBookDetail(
        @PathVariable
        @Min(value=1, message="ID must be greater than or equal to 1")
        Long id
    ) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public Book createBook(
        @Valid
        @RequestBody
        CreateBookDTO book
    ) {
        return bookService.createBook(book);
    }

    @PatchMapping("/{id}/update")
    public Book updateBook(
        @PathVariable
        @Min(value=1, message="ID must be greater than or equal to 1")
        Long id,
        @Valid
        @RequestBody
        UpdateBookDTO book
    ) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteBook(
        @PathVariable
        @Min(value=1, message="ID must be greater than or equal to 1")
        Long id
    ) {
        return bookService.deleteBook(id);
    }
}
