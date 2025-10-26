package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AcaoDTO;
import br.gov.mt.vigilancia.saude.service.AcaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acoes")
@RequiredArgsConstructor
public class AcaoController {

    private final AcaoService acaoService;

    @GetMapping
    public ResponseEntity<List<AcaoDTO>> findAll() {
        return ResponseEntity.ok(acaoService.findAll());
    }
}
