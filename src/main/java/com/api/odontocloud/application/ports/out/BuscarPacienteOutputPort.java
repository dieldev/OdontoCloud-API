package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;

import java.util.List;

public interface BuscarPacienteOutputPort {

    List<PacienteResponseDTO> getAll();

    PacienteResponseDTO getById(Long id);
}
