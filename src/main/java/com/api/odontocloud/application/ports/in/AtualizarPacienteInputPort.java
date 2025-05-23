package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.paciente.AtualizaPacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;

public interface AtualizarPacienteInputPort {

    AtualizaPacienteResponseDTO execute(Long id, Paciente paciente);
}
