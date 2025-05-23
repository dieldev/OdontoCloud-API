package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;

public interface NovoPacienteInputPort {

    PacienteResponseDTO execute(Paciente paciente);
}
