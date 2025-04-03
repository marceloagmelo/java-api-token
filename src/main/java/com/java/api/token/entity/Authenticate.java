package com.java.api.token.entity;

public class Authenticate {
    private String token;

    public Authenticate(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
