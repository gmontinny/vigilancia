package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdiDTO;
import br.gov.mt.vigilancia.saude.service.ProdiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prodis")
@RequiredArgsConstructor
public class ProdiController {

    private final ProdiService prodiService;

    @GetMapping
    public ResponseEntity<List<ProdiDTO>> findAll() {
        return ResponseEntity.ok(prodiService.findAll());
    }
}
