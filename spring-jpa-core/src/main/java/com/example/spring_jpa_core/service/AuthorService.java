package com.example.spring_jpa_core.service;

import org.springframework.stereotype.Service;
import com.example.spring_jpa_core.repository.AuthorRepository;
import java.util.*;
import com.example.spring_jpa_core.model.Author;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(String name) {
        if (name != null && !name.trim().isEmpty()) {
           return authorRepository.findByNameContainingIgnoreCase(name);
        }
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
       Author existingAuthor = authorRepository.findById(id)
               .orElseThrow(() -> new NoSuchElementException("Author not found with id: " + id));

       existingAuthor.setName(author.getName());

       return authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
