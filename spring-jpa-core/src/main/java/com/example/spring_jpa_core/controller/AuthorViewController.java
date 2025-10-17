package com.example.spring_jpa_core.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring_jpa_core.dto.author.CreateAuthorDTO;
import com.example.spring_jpa_core.dto.author.UpdateAuthorDTO;
import com.example.spring_jpa_core.model.Author;
import com.example.spring_jpa_core.service.AuthorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authors")
public class AuthorViewController {
    private final AuthorService authorService;

    public AuthorViewController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/index")
    public String listAuthor(@RequestParam(required = false) String name, Model model) {
        List<Author> authors = authorService.getAllAuthors(name);
        model.addAttribute("authors", authors);
        return "authors/index";
    }


    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/new";
    }

    @PostMapping("/create")
    public String createAuthor(@Valid
        @ModelAttribute("author") CreateAuthorDTO author,
        BindingResult bindingResult,
        Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "authors/new";
        }

        authorService.saveAuthor(author);
        return "redirect:/authors/index";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(Model model, @PathVariable Long id) {
        Author author =  authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "authors/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(
        @PathVariable Long id,
        @Valid @ModelAttribute("author") UpdateAuthorDTO author,
        BindingResult bindingResult,
        Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("author", author);
            return "authors/{id}/edit";
        }
        authorService.updateAuthor(id, author);

        return "redirect:/authors/index";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteAuthor(
        @PathVariable
        Long id
    ) {
        authorService.deleteAuthor(id);
        return "redirect:/authors/index";
    }

}
