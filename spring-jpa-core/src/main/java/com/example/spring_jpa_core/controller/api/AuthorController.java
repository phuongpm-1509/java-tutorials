package com.example.spring_jpa_core.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_jpa_core.service.AuthorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import com.example.spring_jpa_core.dto.author.CreateAuthorDTO;
import com.example.spring_jpa_core.dto.author.UpdateAuthorDTO;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.spring_jpa_core.model.Author;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/authors")
@Validated
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(@RequestParam(required = false) String name) {
        return authorService.getAllAuthors(name);
    }

    @GetMapping("/{id}")
    public Author getAuthorDetail(
        @PathVariable
        @Min(value=1, message="ID must be greater than or equal to 1")
        Long id
    ) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/create")
    public Author createAuthor(
        @Valid
        @RequestBody
        CreateAuthorDTO author
    ) {
        return authorService.saveAuthor(author);
    }

    @PatchMapping("/{id}/update")
    public Author updateAuthor(
        @PathVariable
        @Min(value=1, message="ID must be greater than or equal to 1")
        Long id,
        @Valid
        @RequestBody
        UpdateAuthorDTO author
    ) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteAuthor(
        @PathVariable
        @Min(value=1, message="ID must be greater than or equal to 1")
        Long id
    ) {
        return authorService.deleteAuthor(id);
    }
}
