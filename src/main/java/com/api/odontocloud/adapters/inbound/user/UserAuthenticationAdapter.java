package com.api.odontocloud.adapters.inbound.user;

import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationAdapter implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username)
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o login " + username));
    }

    private UserDetails toUserDetails(JpaUsuarioEntity jpaUsuarioEntity) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(jpaUsuarioEntity.getUsername())
                .password(jpaUsuarioEntity.getPassword())
                .roles(String.valueOf(jpaUsuarioEntity.getRole()))
                .build();
    }
}
