package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LicenciaDTO;
import br.gov.mt.vigilancia.saude.service.LicenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/licencias")
@RequiredArgsConstructor
public class LicenciaController {

    private final LicenciaService licenciaService;

    @GetMapping
    public ResponseEntity<List<LicenciaDTO>> findAll() {
        return ResponseEntity.ok(licenciaService.findAll());
    }
}
