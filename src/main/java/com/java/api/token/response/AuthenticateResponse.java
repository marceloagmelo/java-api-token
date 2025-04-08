package com.java.api.token.response;

import com.java.api.token.entity.Authenticate;

public class AuthenticateResponse {

    private String status;
    private String message;
    private Authenticate authenticate;

    public AuthenticateResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public AuthenticateResponse(String status, String mensagem, Authenticate authenticate) {
        this.message = mensagem;
        this.status = status;
        this.authenticate = authenticate;
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

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }
}
