package com.api.odontocloud.adapters.outbound.repository;

import com.api.odontocloud.adapters.outbound.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByLogin(String login);

    boolean existsByLogin(String login);
}
