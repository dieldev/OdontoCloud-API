package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.paciente.AtualizaPacienteResponseDTO;
import com.api.odontocloud.application.core.domain.Paciente;
import com.api.odontocloud.application.ports.in.AtualizarPacienteInputPort;
import com.api.odontocloud.application.ports.out.BuscarPacienteOutputPort;

public class AtualizarPacienteUseCase implements AtualizarPacienteInputPort {

    private final BuscarPacienteOutputPort buscarPacienteOutputPort;

    public AtualizarPacienteUseCase(BuscarPacienteOutputPort buscarPacienteOutputPort) {
        this.buscarPacienteOutputPort = buscarPacienteOutputPort;
    }

    @Override
    public AtualizaPacienteResponseDTO execute(Long id, Paciente paciente) {
        // Fazer uma interface verificadora de pacientes para retornar um boolean, caso haja um paciente, daí avança pro adapter e faz o salvamento dos dados lá
        // Antes de fazer a linha acima, por favor, alterar a data de atualização do paciente e enviar pro adapter atualizar no banco de dados

        return null;
    }
}
