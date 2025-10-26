package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CupomautoDTO;
import br.gov.mt.vigilancia.saude.service.CupomautoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cupomautos")
@RequiredArgsConstructor
public class CupomautoController {

    private final CupomautoService cupomautoService;

    @GetMapping
    public ResponseEntity<List<CupomautoDTO>> findAll() {
        return ResponseEntity.ok(cupomautoService.findAll());
    }
}
