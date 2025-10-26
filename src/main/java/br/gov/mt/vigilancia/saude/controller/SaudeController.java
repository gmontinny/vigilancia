package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SaudeDTO;
import br.gov.mt.vigilancia.saude.service.SaudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saudes")
@RequiredArgsConstructor
public class SaudeController {

    private final SaudeService saudeService;

    @GetMapping
    public ResponseEntity<List<SaudeDTO>> findAll() {
        return ResponseEntity.ok(saudeService.findAll());
    }
}
