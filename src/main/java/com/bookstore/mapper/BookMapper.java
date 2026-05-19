package com.bookstore.mapper;

import com.bookstore.dto.BookRequest;
import com.bookstore.dto.BookResponse;
import com.bookstore.entity.Book;

public class BookMapper {

    public static Book mapToEntity(BookRequest request) {
        return Book.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .description(request.getDescription())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .publishedDate(request.getPublishedDate())
                .language(request.getLanguage())
                .build();
    }

    public static BookResponse mapToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setIsbn(book.getIsbn());
        response.setDescription(book.getDescription());
        response.setPrice(book.getPrice());
        response.setStockQuantity(book.getStockQuantity());
        response.setPublishedDate(book.getPublishedDate());
        response.setLanguage(book.getLanguage());
        response.setRating(book.getRating());
        response.setAvailable(book.getStockQuantity() > 0);
        
        if (book.getAuthor() != null) {
            response.setAuthor(AuthorMapper.mapToResponse(book.getAuthor()));
        }
        if (book.getCategory() != null) {
            response.setCategory(CategoryMapper.mapToResponse(book.getCategory()));
        }
        
        return response;
    }
}
