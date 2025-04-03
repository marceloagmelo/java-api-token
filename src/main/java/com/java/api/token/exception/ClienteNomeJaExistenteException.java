package com.java.api.token.exception;

import com.java.api.token.constants.ApplicationConstants;
import com.java.api.token.util.PropertiesUtil;


public class ClienteNomeJaExistenteException extends Exception {

    public ClienteNomeJaExistenteException() {
        super(PropertiesUtil.getProperty(ApplicationConstants.PROP_MENSAGEM_CLIENTE_NOME_JA_EXISTE));
    }
}
