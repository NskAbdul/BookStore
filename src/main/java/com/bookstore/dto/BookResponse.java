package com.bookstore.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private String isbn;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private LocalDate publishedDate;
    private String language;
    private BigDecimal rating;
    private AuthorResponse author;
    private CategoryResponse category;
    private boolean available;
}
