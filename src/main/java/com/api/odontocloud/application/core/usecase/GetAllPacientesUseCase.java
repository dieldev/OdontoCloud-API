package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.application.ports.in.GetAllPacientesInputPort;
import com.api.odontocloud.application.ports.out.BuscarPacienteOutputPort;

import java.util.List;

public class GetAllPacientesUseCase implements GetAllPacientesInputPort {

    private final BuscarPacienteOutputPort buscarPacienteOutputPort;

    public GetAllPacientesUseCase(BuscarPacienteOutputPort buscarPacienteOutputPort) {
        this.buscarPacienteOutputPort = buscarPacienteOutputPort;
    }

    @Override
    public List<PacienteResponseDTO> execute() {
        return buscarPacienteOutputPort.getAll();
    }
}
