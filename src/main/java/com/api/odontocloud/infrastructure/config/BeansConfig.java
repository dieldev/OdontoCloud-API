package com.api.odontocloud.infrastructure.config;

import com.api.odontocloud.adapters.outbound.rest.LogarUsuarioAdapter;
import com.api.odontocloud.adapters.outbound.rest.RegistrarUsuarioAdapter;
import com.api.odontocloud.application.core.usecase.LogarUsuarioUseCase;
import com.api.odontocloud.application.core.usecase.RegistrarUsuarioUseCase;
import com.api.odontocloud.application.ports.in.LogarUsuarioInputPort;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public RegistrarUsuarioInputPort registrarUsuarioImpl(RegistrarUsuarioAdapter registrarUsuarioAdapter) {
        return new RegistrarUsuarioUseCase(registrarUsuarioAdapter);
    }

    @Bean
    public LogarUsuarioInputPort logarUsuarioImpl(LogarUsuarioAdapter logarUsuarioAdapter) {
        return new LogarUsuarioUseCase(logarUsuarioAdapter);
    }
}
