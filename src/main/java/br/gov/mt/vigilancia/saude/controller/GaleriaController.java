package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GaleriaDTO;
import br.gov.mt.vigilancia.saude.service.GaleriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/galerias")
@RequiredArgsConstructor
public class GaleriaController {

    private final GaleriaService galeriaService;

    @GetMapping
    public ResponseEntity<List<GaleriaDTO>> findAll() {
        return ResponseEntity.ok(galeriaService.findAll());
    }
}
