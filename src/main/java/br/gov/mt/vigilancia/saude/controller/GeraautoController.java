package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraautoDTO;
import br.gov.mt.vigilancia.saude.service.GeraautoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/geraautos")
@RequiredArgsConstructor
public class GeraautoController {

    private final GeraautoService geraautoService;

    @GetMapping
    public ResponseEntity<List<GeraautoDTO>> findAll() {
        return ResponseEntity.ok(geraautoService.findAll());
    }
}
