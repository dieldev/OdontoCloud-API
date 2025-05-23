package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;

public interface SalvarPacienteOutputPort {

    PacienteResponseDTO excute(Paciente paciente);
}
