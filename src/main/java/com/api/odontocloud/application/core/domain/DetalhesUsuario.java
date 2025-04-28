package com.api.odontocloud.application.core.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class DetalhesUsuario {

    private Integer id;
    private Usuario usuario;
    private String cro;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataBloqueio;

    public DetalhesUsuario() {}

    public DetalhesUsuario(Integer id, Usuario usuario, String cro, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, LocalDateTime dataBloqueio) {
        if (id != null) {
            this.id = id;
        }
        if (usuario != null) {
            this.usuario = usuario;
        }
        this.cro = cro;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.dataBloqueio = dataBloqueio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(LocalDateTime dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhesUsuario that = (DetalhesUsuario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DetalhesUsuario{" +
                "id=" + id +
                ", cro='" + cro + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                ", dataBloqueio=" + dataBloqueio +
                ", usuarioId=" + (usuario != null ? usuario.getId() : "null") +
                '}';
    }
}
