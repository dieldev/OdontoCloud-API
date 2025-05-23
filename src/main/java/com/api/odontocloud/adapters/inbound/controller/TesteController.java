package com.api.odontocloud.adapters.inbound.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
@RequiredArgsConstructor
public class TesteController {

    // Somente recepcionistas devem registrar consultas
    @PostMapping("/registrarConsulta")
    public ResponseEntity registrarConsulta(String msg) {
        return ResponseEntity.ok("Você está com a permissão ideal e foi autorizado! :)");
    }
}
