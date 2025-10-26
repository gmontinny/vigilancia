package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ReclamacaoDTO;
import br.gov.mt.vigilancia.saude.service.ReclamacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reclamacoes")
@RequiredArgsConstructor
public class ReclamacaoController {

    private final ReclamacaoService reclamacaoService;

    @GetMapping
    public ResponseEntity<List<ReclamacaoDTO>> findAll() {
        return ResponseEntity.ok(reclamacaoService.findAll());
    }
}
