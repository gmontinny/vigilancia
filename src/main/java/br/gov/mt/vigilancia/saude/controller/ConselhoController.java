package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ConselhoDTO;
import br.gov.mt.vigilancia.saude.service.ConselhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conselhos")
@RequiredArgsConstructor
public class ConselhoController {

    private final ConselhoService conselhoService;

    @GetMapping
    public ResponseEntity<List<ConselhoDTO>> findAll() {
        return ResponseEntity.ok(conselhoService.findAll());
    }
}
