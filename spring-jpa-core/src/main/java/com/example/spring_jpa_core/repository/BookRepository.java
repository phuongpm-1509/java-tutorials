package com.example.spring_jpa_core.repository;
import com.example.spring_jpa_core.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCase(String name);
}
