package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.adapters.mapper.PacienteMapper;
import com.api.odontocloud.adapters.outbound.entity.JpaPacienteEntity;
import com.api.odontocloud.adapters.outbound.repository.PacienteRepository;
import com.api.odontocloud.application.core.domain.Paciente;
import com.api.odontocloud.application.ports.out.SalvarPacienteOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarPacienteAdapter implements SalvarPacienteOutputPort {

    private final PacienteMapper pacienteMapper;
    private final PacienteRepository pacienteRepository;

    public SalvarPacienteAdapter(PacienteMapper pacienteMapper, PacienteRepository pacienteRepository) {
        this.pacienteMapper = pacienteMapper;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteResponseDTO excute(Paciente paciente) {
        JpaPacienteEntity pacienteEntity = pacienteRepository.save(pacienteMapper.toEntity(paciente));
        return pacienteMapper.toResponseDTO(pacienteEntity);
    }
}
