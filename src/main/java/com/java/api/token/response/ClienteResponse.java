package com.java.api.token.response;

import com.java.api.token.entity.Cliente;

public class ClienteResponse {

    private String status;
    private String message;
    private Cliente cliente;

    public ClienteResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public ClienteResponse(String status, String mensagem, Cliente cliente) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
