package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.adapters.mapper.PacienteMapper;
import com.api.odontocloud.adapters.outbound.entity.JpaPacienteEntity;
import com.api.odontocloud.adapters.outbound.repository.PacienteRepository;
import com.api.odontocloud.application.core.domain.Paciente;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.ports.out.BuscarPacienteOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BuscarPacienteAdapter implements BuscarPacienteOutputPort {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public BuscarPacienteAdapter(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public List<PacienteResponseDTO> getAll() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PacienteResponseDTO getById(Long id) {
        Optional<JpaPacienteEntity> entityPaciente = pacienteRepository.findById(id.intValue());
        if (entityPaciente.isEmpty()) {
            throw new ValidacaoException("Paciente não encontrado!");
        }

        return pacienteMapper.toResponseDTO(entityPaciente.get());
    }
}
