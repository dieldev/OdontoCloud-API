package com.api.odontocloud.adapters.outbound.repository;

import com.api.odontocloud.adapters.outbound.entity.JpaPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<JpaPacienteEntity, Integer> {
}
