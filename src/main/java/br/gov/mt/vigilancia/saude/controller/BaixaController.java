package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BaixaDTO;
import br.gov.mt.vigilancia.saude.service.BaixaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baixas")
@RequiredArgsConstructor
public class BaixaController {

    private final BaixaService baixaService;

    @GetMapping
    public ResponseEntity<List<BaixaDTO>> findAll() {
        return ResponseEntity.ok(baixaService.findAll());
    }
}
