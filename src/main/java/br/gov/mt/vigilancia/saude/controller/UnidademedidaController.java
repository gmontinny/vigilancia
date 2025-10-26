package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UnidademedidaDTO;
import br.gov.mt.vigilancia.saude.service.UnidademedidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidades-medida")
@RequiredArgsConstructor
public class UnidademedidaController {

    private final UnidademedidaService unidademedidaService;

    @GetMapping
    public ResponseEntity<List<UnidademedidaDTO>> findAll() {
        return ResponseEntity.ok(unidademedidaService.findAll());
    }
}
