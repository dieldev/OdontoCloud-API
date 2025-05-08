package com.api.odontocloud.adapters.outbound.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tblDetalhesUsuario")
public class JpaDetalhesUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private JpaUsuarioEntity usuario;
    private String cro;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataBloqueio;

    public JpaDetalhesUsuarioEntity() {}

    public JpaDetalhesUsuarioEntity(int id, JpaUsuarioEntity usuario, String cro, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, LocalDateTime dataBloqueio) {
        this.id = id;
        if (usuario != null) {
            this.usuario = usuario;
        }
        this.cro = cro;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.dataBloqueio = dataBloqueio;
    }

    public JpaDetalhesUsuarioEntity(JpaUsuarioEntity usuario, String cro, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, LocalDateTime dataBloqueio) {
        this.usuario = usuario;
        this.cro = cro;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.dataBloqueio = dataBloqueio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JpaUsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(JpaUsuarioEntity usuario) {
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
        JpaDetalhesUsuarioEntity that = (JpaDetalhesUsuarioEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "JpaDetalhesUsuarioEntity{" +
                "id=" + id +
                ", cro='" + cro + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                ", dataBloqueio=" + dataBloqueio +
                '}';
    }
}
