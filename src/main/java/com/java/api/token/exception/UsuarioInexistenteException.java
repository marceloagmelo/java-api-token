package com.java.api.token.exception;

import com.java.api.token.constants.ApplicationConstants;
import com.java.api.token.util.PropertiesUtil;

public class UsuarioInexistenteException extends Exception {

    public UsuarioInexistenteException() {
        super(PropertiesUtil.getProperty(ApplicationConstants.PROP_MENSAGEM_USUARIO_NAO_ENCONTRADO));
    }
}