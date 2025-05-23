package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;
import com.api.odontocloud.application.ports.in.NovoPacienteInputPort;
import com.api.odontocloud.application.ports.out.SalvarPacienteOutputPort;

public class NovoPacienteUseCase implements NovoPacienteInputPort {

    private final SalvarPacienteOutputPort salvarPacienteOutputPort;

    public NovoPacienteUseCase(SalvarPacienteOutputPort salvarPacienteOutputPort) {
        this.salvarPacienteOutputPort = salvarPacienteOutputPort;
    }

    @Override
    public PacienteResponseDTO execute(Paciente paciente) {
        return salvarPacienteOutputPort.excute(paciente);
    }
}
