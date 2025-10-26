package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RespostaDTO;
import br.gov.mt.vigilancia.saude.service.RespostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/respostas")
@RequiredArgsConstructor
public class RespostaController {

    private final RespostaService respostaService;

    @GetMapping
    public ResponseEntity<List<RespostaDTO>> findAll() {
        return ResponseEntity.ok(respostaService.findAll());
    }
}
