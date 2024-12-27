package com.api.odontocloud.adapters.outbound.repository;

import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<JpaUsuarioEntity, Long> {

    Optional<JpaUsuarioEntity> findByLogin(String login);

    boolean existsByLogin(String login);
}
