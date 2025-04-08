package com.java.api.token.response;

import com.java.api.token.entity.User;

public class UsuarioResponse {

    private String status;
    private String message;
    private User user;

    public UsuarioResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public UsuarioResponse(String status, String mensagem, User user) {
        this.message = mensagem;
        this.status = status;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
