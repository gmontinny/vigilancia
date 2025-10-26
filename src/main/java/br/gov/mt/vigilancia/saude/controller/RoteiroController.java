package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RoteiroDTO;
import br.gov.mt.vigilancia.saude.service.RoteiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roteiros")
@RequiredArgsConstructor
public class RoteiroController {

    private final RoteiroService roteiroService;

    @GetMapping
    public ResponseEntity<List<RoteiroDTO>> findAll() {
        return ResponseEntity.ok(roteiroService.findAll());
    }
}
