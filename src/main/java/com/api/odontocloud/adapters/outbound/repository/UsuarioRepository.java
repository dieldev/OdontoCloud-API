package com.api.odontocloud.adapters.outbound.repository;

import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<JpaUsuarioEntity, Long> {

    @Query("SELECT u FROM JpaUsuarioEntity u LEFT JOIN FETCH u.detalhes WHERE u.login = :login")
    Optional<JpaUsuarioEntity> findByLogin(String login);

    boolean existsByLogin(String login);
}
