package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.adapters.inbound.dto.paciente.AtualizaPacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;

public interface AtualizarPacienteOutputPort {

    AtualizaPacienteResponseDTO execute(Paciente paciente);
}
