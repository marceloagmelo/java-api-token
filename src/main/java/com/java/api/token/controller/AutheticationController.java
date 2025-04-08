package com.java.api.token.controller;

import com.java.api.token.constants.ApplicationConstants;
import com.java.api.token.entity.Authenticate;
import com.java.api.token.response.AuthenticateResponse;
import com.java.api.token.service.AuthenticationService;
import org.springframework.web.bind.annotation.CrossOrigin;
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
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado"),
    })
    @PostMapping("authenticate")
    public ResponseEntity<?> authenticate(Authentication authentication) {
        try {
             Authenticate authenticate = authenticationService.authenticate(authentication);
            AuthenticateResponse response = new AuthenticateResponse(ApplicationConstants.STATUS_OK,
                    ApplicationConstants.MENSAGEM_USUARIO_TOKEN_SUCESSO,
                    authenticate);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            AuthenticateResponse response = new AuthenticateResponse(ApplicationConstants.STATUS_ERROR,
                    e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
