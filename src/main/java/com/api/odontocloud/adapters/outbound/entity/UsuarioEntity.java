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

@Entity
@Table(name = "tblUsuario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String login;
    private String password;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public UsuarioEntity(String nome, String sobrenome, String telefone, String login, String password, boolean ativo, UsuarioRole usuarioRole) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.login = login;
        this.password = password;
        this.ativo = ativo;
        this.role = usuarioRole;
    }

    // Converte UsuarioEntity para Usuario (Domínio)
    public Usuario toDomain() {
        return new Usuario(
                this.id,
                this.nome,
                this.sobrenome,
                this.telefone,
                this.login,
                this.password,
                this.ativo,
                this.role
        );
    }

    // Converte Usuario (Domínio) para UsuarioEntity
    public static UsuarioEntity fromDomain(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getLogin(),
                usuario.getPassword(),
                usuario.isAtivo(),
                usuario.getUsuarioRole()
        );
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
        return true;
    }
}
