package com.java.api.token.response;

import com.java.api.token.entity.Cliente;
import com.java.api.token.entity.User;

import java.util.List;

public class UsuarioListaResponse {

    private String status;
    private String message;
    private List<User> user;

    public UsuarioListaResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public UsuarioListaResponse(String status, String mensagem, List<User> user) {
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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}