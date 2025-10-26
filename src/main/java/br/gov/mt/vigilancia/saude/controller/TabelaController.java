package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TabelaDTO;
import br.gov.mt.vigilancia.saude.service.TabelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabelas")
@RequiredArgsConstructor
public class TabelaController {

    private final TabelaService tabelaService;

    @GetMapping
    public ResponseEntity<List<TabelaDTO>> findAll() {
        return ResponseEntity.ok(tabelaService.findAll());
    }
}
