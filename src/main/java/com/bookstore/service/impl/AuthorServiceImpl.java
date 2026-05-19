package com.bookstore.service.impl;

import com.bookstore.dto.AuthorRequest;
import com.bookstore.dto.AuthorResponse;
import com.bookstore.entity.Author;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.mapper.AuthorMapper;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = AuthorMapper.mapToEntity(request);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.mapToResponse(savedAuthor);
    }

    @Override
    @Transactional
    public AuthorResponse updateAuthor(Long id, AuthorRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

        author.setName(request.getName());
        author.setBiography(request.getBiography());

        Author updatedAuthor = authorRepository.save(author);
        return AuthorMapper.mapToResponse(updatedAuthor);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        authorRepository.delete(author);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        return AuthorMapper.mapToResponse(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper::mapToResponse)
                .collect(Collectors.toList());
    }
}
