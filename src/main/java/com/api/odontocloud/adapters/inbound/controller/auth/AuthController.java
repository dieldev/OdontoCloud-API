package com.api.odontocloud.adapters.inbound.controller.auth;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.RegisterRequestDTO;
import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.application.ports.in.LogarUsuarioInputPort;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import com.api.odontocloud.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegistrarUsuarioInputPort registrarUsuarioInputPort;
    private final LogarUsuarioInputPort logarUsuarioInputPort;
    private final UsuarioMapper usuarioMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity registrarUsuario(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(registrarUsuarioInputPort.execute(usuarioMapper.registerDtoToDomain(registerRequestDTO)));
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(logarUsuarioInputPort.execute(loginRequestDTO));
    }
}