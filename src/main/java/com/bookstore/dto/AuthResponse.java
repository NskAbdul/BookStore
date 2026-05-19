package com.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String username;
    private String type = "Bearer";

    public AuthResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
