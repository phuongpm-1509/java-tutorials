package com.example.spring_jpa_core.service;

import org.springframework.stereotype.Service;

import com.example.spring_jpa_core.dto.book.CreateBookDTO;
import com.example.spring_jpa_core.dto.book.UpdateBookDTO;
import com.example.spring_jpa_core.exception.ResourceNotFoundException;
import com.example.spring_jpa_core.model.Author;
import com.example.spring_jpa_core.model.Book;

import java.util.*;
import com.example.spring_jpa_core.repository.BookRepository;
import com.example.spring_jpa_core.repository.AuthorRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks(String title) {
        if (title != null && !title.trim().isEmpty()) {
           return bookRepository.findByTitleContainingIgnoreCase(title);
        }
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book createBook(CreateBookDTO book) {
        Book newBook = new Book();
        Author author = authorRepository.findById(book.getAuthorId())
        .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + book.getAuthorId()));

        newBook.setTitle(book.getTitle());
        newBook.setDescription(book.getDescription());
        newBook.setCategory(book.getCategory());
        newBook.setAuthor(author);

        return bookRepository.save(newBook);
    }

    public Book updateBook(Long id, UpdateBookDTO book) {
        Book existingBook = bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setDescription(book.getDescription());
        existingBook.setCategory(book.getCategory());

        return bookRepository.save(existingBook);
    }

    public boolean deleteBook(Long id) {
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        bookRepository.deleteById(book.getId());
        return true;
    }
}
