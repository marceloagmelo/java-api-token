package com.java.api.token.controller;

import com.java.api.token.service.AuthenticationService;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@Tag(name = "open-api")
public class AutheticationController {
    private final AuthenticationService authenticationService;

    public AutheticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Autenticação do usuário cliente", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
    })
    @PostMapping("authenticate")
    public ResponseEntity<?> authenticate(Authentication authentication) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(authentication));
    }

}
