package com.java.api.token.controller;

import java.util.List;

import com.java.api.token.dto.UserDTO;
import com.java.api.token.entity.User;
import com.java.api.token.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<User>> listUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUsers());
    }

    @Operation(summary = "Cadastrar usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos")
    })
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return ResponseEntity.ok("User created successfully");
    }
}