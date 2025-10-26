package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResponsavelTecnicoDTO;
import br.gov.mt.vigilancia.saude.service.ResponsavelTecnicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/responsaveis-tecnicos")
@RequiredArgsConstructor
public class ResponsavelTecnicoController {

    private final ResponsavelTecnicoService responsavelTecnicoService;

    @GetMapping
    public ResponseEntity<List<ResponsavelTecnicoDTO>> findAll() {
        return ResponseEntity.ok(responsavelTecnicoService.findAll());
    }
}
