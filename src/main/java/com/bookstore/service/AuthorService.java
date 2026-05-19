package com.bookstore.service;

import com.bookstore.dto.AuthorRequest;
import com.bookstore.dto.AuthorResponse;
import java.util.List;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorRequest request);
    AuthorResponse updateAuthor(Long id, AuthorRequest request);
    void deleteAuthor(Long id);
    AuthorResponse getAuthorById(Long id);
    List<AuthorResponse> getAllAuthors();
}
