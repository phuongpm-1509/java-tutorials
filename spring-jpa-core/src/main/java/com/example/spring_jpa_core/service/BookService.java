package com.example.spring_jpa_core.service;

import org.springframework.stereotype.Service;

import com.example.spring_jpa_core.model.Book;

import java.util.*;
import com.example.spring_jpa_core.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(String title) {
        if (title != null && !title.trim().isEmpty()) {
           return bookRepository.findByTitleContainingIgnoreCase(title);
        }
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id: " + id));

        existingBook.setTitle(book.getTitle());

        existingBook.setDescription(book.getDescription());
        existingBook.setCategory(book.getCategory());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
