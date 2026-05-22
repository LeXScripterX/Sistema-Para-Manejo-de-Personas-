package com.ucompensar.proyectofinal.jwt;


public class AuthResponse {

    private String token;
    private String roles;
    private String user;

    public AuthResponse(String token, String roles, String user) {
        this.token = token;
        this.roles = roles;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public String getRoles() {
        return roles;
    }

    public String getUser() {
        return user;
    }
}