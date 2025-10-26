package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MotivoDTO;
import br.gov.mt.vigilancia.saude.service.MotivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/motivos")
@RequiredArgsConstructor
public class MotivoController {

    private final MotivoService motivoService;

    @GetMapping
    public ResponseEntity<List<MotivoDTO>> findAll() {
        return ResponseEntity.ok(motivoService.findAll());
    }
}
