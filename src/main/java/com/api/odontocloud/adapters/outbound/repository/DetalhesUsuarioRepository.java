package com.api.odontocloud.adapters.outbound.repository;

import com.api.odontocloud.adapters.outbound.entity.JpaDetalhesUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalhesUsuarioRepository extends JpaRepository<JpaDetalhesUsuarioEntity, Integer> {
}
