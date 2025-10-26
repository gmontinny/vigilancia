package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AlvaraDTO;
import br.gov.mt.vigilancia.saude.service.AlvaraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alvaras")
@RequiredArgsConstructor
public class AlvaraController {

    private final AlvaraService alvaraService;

    @GetMapping
    public ResponseEntity<List<AlvaraDTO>> findAll() {
        return ResponseEntity.ok(alvaraService.findAll());
    }
}
