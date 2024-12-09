package com.api.odontocloud.application.core.domain;

public enum UsuarioRole {
    ADMIN("admin"),
    DENTISTA("dentista"),
    RECEPCIONISTA("recepcionista"),
    USER("usuario");

    private String role;

    UsuarioRole(String role) { this.role = role; }

    public String getRole() { return role; }
}
