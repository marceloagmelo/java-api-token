package com.java.api.token.controller;

import java.io.IOException;

import com.java.api.token.constants.ApplicationConstants;
import com.java.api.token.dto.UserDTO;
import com.java.api.token.exception.UsuarioInexistenteException;
import com.java.api.token.exception.UsuarioNomeJaExistenteException;
import com.java.api.token.exception.UsuarioNomeObrigatorioException;
import com.java.api.token.response.UsuarioListaResponse;
import com.java.api.token.response.UsuarioResponse;
import com.java.api.token.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user")
@Tag(name = "open-api")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Listagem dos usuários", method = "GET")
    @GetMapping("/list")
    public ResponseEntity<?> listUser() throws IOException {
        try {
            UsuarioListaResponse response = new UsuarioListaResponse(ApplicationConstants.STATUS_OK,
                    ApplicationConstants.MENSAGEM_USUARIO_LISTA_SUCESSO,
                    userService.listUsers());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @Operation(summary = "Registrar usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws IOException {
        try {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_OK,
                    ApplicationConstants.MENSAGEM_USUARIO_CRIADO_SUCESSO,
                    userService.register(userDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (UsuarioNomeObrigatorioException en) {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_ERROR, en.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (UsuarioNomeJaExistenteException ec) {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_ERROR, ec.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } catch (Exception e) {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @Operation(summary = "Excluir cliente", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente excluído com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Cliente ou serviço não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Integer id) throws IOException {
        try {
            userService.excluir(id);
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_OK,
                    ApplicationConstants.MENSAGEM_USUARIO_DELETADO_SUCESSO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (UsuarioInexistenteException ec) {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_ERROR, ec.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception e) {
            UsuarioResponse response = new UsuarioResponse(ApplicationConstants.STATUS_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}