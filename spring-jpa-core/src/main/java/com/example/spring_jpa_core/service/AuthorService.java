package com.example.spring_jpa_core.service;

import org.springframework.stereotype.Service;
import com.example.spring_jpa_core.repository.AuthorRepository;
import java.util.*;

import com.example.spring_jpa_core.dto.author.CreateAuthorDTO;
import com.example.spring_jpa_core.dto.author.UpdateAuthorDTO;
import com.example.spring_jpa_core.exception.ResourceNotFoundException;
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

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    public Author saveAuthor(CreateAuthorDTO author) {
        Author newAuthor = new Author();
        newAuthor.setName(author.getName());
        return authorRepository.save(newAuthor);
    }

    public Author updateAuthor(Long id, UpdateAuthorDTO author) {
       Author existingAuthor = authorRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

       existingAuthor.setName(author.getName());

       return authorRepository.save(existingAuthor);
    }

    public boolean deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

        authorRepository.deleteById(author.getId());
        return true;
    }
}
