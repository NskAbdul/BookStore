package com.bookstore.mapper;

import com.bookstore.dto.AuthorRequest;
import com.bookstore.dto.AuthorResponse;
import com.bookstore.entity.Author;

public class AuthorMapper {

    public static Author mapToEntity(AuthorRequest request) {
        return Author.builder()
                .name(request.getName())
                .biography(request.getBiography())
                .build();
    }

    public static AuthorResponse mapToResponse(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setBiography(author.getBiography());
        return response;
    }
}
