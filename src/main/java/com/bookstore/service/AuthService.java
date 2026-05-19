package com.bookstore.service;

import com.bookstore.dto.AuthRequest;
import com.bookstore.dto.RegisterRequest;

public interface AuthService {
    String login(AuthRequest request);
    String register(RegisterRequest request);
}
