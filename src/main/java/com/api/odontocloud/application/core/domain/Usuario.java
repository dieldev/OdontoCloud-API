package com.api.odontocloud.application.core.domain;

import java.util.Objects;

public class Usuario {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String login;
    private String password;
    private boolean ativo;
    private UsuarioRole usuarioRole;

    public Usuario() {}

    public Usuario(Integer id, String nome, String sobrenome, String telefone, String login, String password, boolean ativo, UsuarioRole usuarioRole) {
        if (id != null) {
            this.id = id;
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.login = login;
        this.password = password;
        this.ativo = ativo;
        this.usuarioRole = usuarioRole;
    }

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public UsuarioRole getUsuarioRole() {
        return usuarioRole;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setUsuarioRole(UsuarioRole usuarioRole) {
        this.usuarioRole = usuarioRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ativo=" + ativo +
                ", usuarioRole=" + usuarioRole +
                '}';
    }
}