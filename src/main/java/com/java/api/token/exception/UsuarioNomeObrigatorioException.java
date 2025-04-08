package com.java.api.token.exception;

import com.java.api.token.constants.ApplicationConstants;
import com.java.api.token.util.PropertiesUtil;


public class UsuarioNomeObrigatorioException extends Exception {

    public UsuarioNomeObrigatorioException() {
        super(PropertiesUtil.getProperty(ApplicationConstants.PROP_MENSAGEM_USUARIO_NOME_OBRIGATORIO));
    }
}