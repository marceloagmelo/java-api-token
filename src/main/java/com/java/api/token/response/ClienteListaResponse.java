package com.java.api.token.response;

import com.java.api.token.entity.Cliente;

import java.util.List;

public class ClienteListaResponse {

    private String status;
    private String message;
    private List<Cliente> cliente;

    public ClienteListaResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public ClienteListaResponse(String status, String mensagem, List<Cliente> cliente) {
        this.message = mensagem;
        this.status = status;
        this.cliente = cliente;
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

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
}