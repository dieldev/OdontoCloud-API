package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;

public interface GetPacienteByIdInputPort {

    PacienteResponseDTO execute(Long id);
}
