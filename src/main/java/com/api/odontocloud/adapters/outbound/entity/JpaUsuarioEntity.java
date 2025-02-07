package com.api.odontocloud.adapters.outbound.entity;

import com.api.odontocloud.application.core.domain.UsuarioRole;
import com.api.odontocloud.application.core.domain.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tblUsuario")
public class JpaUsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    private boolean ativo;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private JpaDetalhesUsuarioEntity detalhes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsuarioRole role;

    public JpaUsuarioEntity() {}

    public JpaUsuarioEntity(String nome, String sobrenome, String telefone, String login, String password, boolean ativo, UsuarioRole usuarioRole) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.login = login;
        this.password = password;
        this.ativo = ativo;
        this.role = usuarioRole;
    }

    public JpaUsuarioEntity(String nome, String sobrenome, String telefone, String login, String password, boolean ativo, UsuarioRole usuarioRole, JpaDetalhesUsuarioEntity detalhes) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.login = login;
        this.password = password;
        this.ativo = ativo;
        this.role = usuarioRole;
        this.detalhes = detalhes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else if (this.role == UsuarioRole.DENTISTA) return List.of(new SimpleGrantedAuthority("ROLE_DENTISTA"), new SimpleGrantedAuthority("ROLE_USER"));
        else if (this.role == UsuarioRole.RECEPCIONISTA) return List.of(new SimpleGrantedAuthority("ROLE_RECEPCIONISTA"), new SimpleGrantedAuthority("ROLE_USER"));
         else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public JpaDetalhesUsuarioEntity getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(JpaDetalhesUsuarioEntity detalhes) {
        this.detalhes = detalhes;
    }

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaUsuarioEntity that = (JpaUsuarioEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "JpaUsuarioEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ativo=" + ativo +
                ", detalhes=" + detalhes +
                ", role=" + role +
                '}';
    }
}
