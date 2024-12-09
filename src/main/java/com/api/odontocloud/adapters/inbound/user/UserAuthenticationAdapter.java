package com.api.odontocloud.adapters.inbound.user;

import com.api.odontocloud.adapters.outbound.entity.UsuarioEntity;
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

    private UserDetails toUserDetails(UsuarioEntity usuarioEntity) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(usuarioEntity.getUsername())
                .password(usuarioEntity.getPassword())
                .roles(String.valueOf(usuarioEntity.getRole()))
                .build();
    }
}
