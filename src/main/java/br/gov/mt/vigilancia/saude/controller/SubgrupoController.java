package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SubgrupoDTO;
import br.gov.mt.vigilancia.saude.service.SubgrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subgrupos")
@RequiredArgsConstructor
public class SubgrupoController {

    private final SubgrupoService subgrupoService;

    @GetMapping
    public ResponseEntity<List<SubgrupoDTO>> findAll() {
        return ResponseEntity.ok(subgrupoService.findAll());
    }
}
