package com.api.odontocloud.adapters.inbound.controller.paciente;

import com.api.odontocloud.adapters.inbound.dto.paciente.AtualizaPacienteRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.paciente.NovoPacienteRequestDTO;
import com.api.odontocloud.adapters.mapper.PacienteMapper;
import com.api.odontocloud.application.ports.in.AtualizarPacienteInputPort;
import com.api.odontocloud.application.ports.in.GetAllPacientesInputPort;
import com.api.odontocloud.application.ports.in.GetPacienteByIdInputPort;
import com.api.odontocloud.application.ports.in.NovoPacienteInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteMapper pacienteMapper;
    private final GetAllPacientesInputPort getAllPacientesInputPort;
    private final GetPacienteByIdInputPort getPacienteByIdInputPort;
    private final NovoPacienteInputPort novoPacienteInputPort;
    private final AtualizarPacienteInputPort atualizarPacienteInputPort;

    // CORRIGIR PARA VIR APENAS OS PACIENTES QUE NÃO TEM DATA DE BLOQUEIO
    @GetMapping
    public ResponseEntity getAllPacientes() {
        return ResponseEntity.ok(getAllPacientesInputPort.execute());
    }

    // CORRIGIR PARA VIR APENAS OS PACIENTES QUE NÃO TEM DATA DE BLOQUEIO
    @GetMapping("/{id}")
    public ResponseEntity getPacienteById(@PathVariable Long id) {
        return ResponseEntity.ok(getPacienteByIdInputPort.execute(id));
    }

    @PostMapping
    public ResponseEntity cadastrarPaciente(@Valid @RequestBody NovoPacienteRequestDTO novoPacienteRequestDTO) {
        return ResponseEntity.ok(novoPacienteInputPort.execute(pacienteMapper.fromNewRequestToDomain(novoPacienteRequestDTO)));
    }

    @PutMapping("/{ìd}")
    public ResponseEntity atualizarPaciente(@PathVariable Long id, @RequestBody AtualizaPacienteRequestDTO atualizaPacienteRequestDTO) {
        return ResponseEntity.ok(atualizarPacienteInputPort.execute(id, pacienteMapper.fromUpdateRequestToDomain(atualizaPacienteRequestDTO)));
    }

    // Falta fazer o "delete" que seria apenas colocar no banco o campo de data bloqueio.
}
