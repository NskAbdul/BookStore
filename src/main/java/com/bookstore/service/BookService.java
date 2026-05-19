package com.bookstore.service;

import com.bookstore.dto.BookRequest;
import com.bookstore.dto.BookResponse;
import com.bookstore.dto.PageResponse;

public interface BookService {
    BookResponse createBook(BookRequest request);
    BookResponse updateBook(Long id, BookRequest request);
    void deleteBook(Long id);
    BookResponse getBookById(Long id);
    PageResponse<BookResponse> getAllBooks(int pageNo, int pageSize, String sortBy, String sortDir);
    PageResponse<BookResponse> searchBooksByTitle(String title, int pageNo, int pageSize);
    PageResponse<BookResponse> getBooksByCategory(Long categoryId, int pageNo, int pageSize);
    PageResponse<BookResponse> getBooksByAuthor(Long authorId, int pageNo, int pageSize);
}
