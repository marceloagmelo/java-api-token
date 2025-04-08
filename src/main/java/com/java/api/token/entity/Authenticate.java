package com.java.api.token.entity;

public class Authenticate {
    private String type;
    private String expires;
    private String token;

    public Authenticate(String type, String expires, String token) {
        this.type = type;
        this.expires = expires;
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
}
