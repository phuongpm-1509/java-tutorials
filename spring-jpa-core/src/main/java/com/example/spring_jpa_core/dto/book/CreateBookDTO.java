package com.example.spring_jpa_core.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import com.example.spring_jpa_core.model.Category;

public class CreateBookDTO {
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than or equal to 100 characters")
    private String title;

    @Size(max = 1000, message = "Description must be less than or equal to 100 characters")
    private String description;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Author ID is required")
    @Min(value = 1, message = "The value must be positive")
    private Long authorId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
