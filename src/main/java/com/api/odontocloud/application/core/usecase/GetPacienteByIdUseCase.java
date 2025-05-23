package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.application.ports.in.GetPacienteByIdInputPort;
import com.api.odontocloud.application.ports.out.BuscarPacienteOutputPort;

public class GetPacienteByIdUseCase implements GetPacienteByIdInputPort {

    private final BuscarPacienteOutputPort buscarPacienteOutputPort;

    public GetPacienteByIdUseCase(BuscarPacienteOutputPort buscarPacienteOutputPort) {
        this.buscarPacienteOutputPort = buscarPacienteOutputPort;
    }

    @Override
    public PacienteResponseDTO execute(Long id) {
        return buscarPacienteOutputPort.getById(id);
    }
}
