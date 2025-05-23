package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;

import java.util.List;

public interface GetAllPacientesInputPort {

    List<PacienteResponseDTO> execute();
}