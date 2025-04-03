package com.java.api.token.service;

import java.util.List;

import com.java.api.token.dto.ClienteDTO;
import com.java.api.token.entity.Cliente;
import com.java.api.token.exception.ClienteInexistenteException;
import com.java.api.token.exception.ClienteNomeJaExistenteException;
import com.java.api.token.exception.ClienteNomeObrigatorioException;
import com.java.api.token.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Integer id) throws ClienteInexistenteException {

        Cliente cliente = clienteRepository.findByIdCliente(id);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }

        return cliente;

    }

    public Cliente getCliente(String nomeCliente) throws ClienteInexistenteException {

        Cliente cliente = clienteRepository.findByNomeCliente(nomeCliente);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }

        return cliente;

    }

    public List<Cliente> getClientes() throws Exception {
        return clienteRepository.findAll();
    }

    public Cliente criar(ClienteDTO clienteDTO)
            throws ClienteNomeJaExistenteException, ClienteNomeObrigatorioException {
        Cliente cliente = clienteRepository.findByNomeCliente(clienteDTO.getNome());

        if (cliente != null) {
            throw new ClienteNomeJaExistenteException();
        }

        if ("".equals(clienteDTO.getNome())) {
            throw new ClienteNomeObrigatorioException();
        }

        Cliente clienteNovo = new Cliente();
        clienteNovo.setNome(clienteDTO.getNome());
        return clienteRepository.saveAndFlush(clienteNovo);
    }

    public Cliente alterar(int id, ClienteDTO clienteDTO)
            throws ClienteNomeJaExistenteException, ClienteInexistenteException, ClienteNomeObrigatorioException {
        Cliente clienteValidado = clienteRepository.findByNomeCliente(clienteDTO.getNome());
        if (clienteValidado != null) {
            throw new ClienteNomeJaExistenteException();
        }

        Cliente cliente = clienteRepository.findByIdCliente(id);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }

        if ("".equals(clienteDTO.getNome())) {
            throw new ClienteNomeObrigatorioException();
        }

        cliente.setNome(clienteDTO.getNome());
        return clienteRepository.saveAndFlush(cliente);
    }

    public void excluir(int id) throws ClienteInexistenteException {
        Cliente cliente = clienteRepository.findByIdCliente(id);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }
        clienteRepository.deleteById(id);
    }
}
