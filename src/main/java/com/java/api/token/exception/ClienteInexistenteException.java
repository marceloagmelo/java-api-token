package com.java.api.token.exception;

import com.java.api.token.constants.ApplicationConstants;
import com.java.api.token.util.PropertiesUtil;

public class ClienteInexistenteException extends Exception {

    public ClienteInexistenteException() {
        super(PropertiesUtil.getProperty(ApplicationConstants.PROP_MENSAGEM_CLIENTE_NAO_ENCONTRADO));
    }
}