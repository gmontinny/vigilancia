package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BpaDTO;
import br.gov.mt.vigilancia.saude.service.BpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bpas")
@RequiredArgsConstructor
public class BpaController {

    private final BpaService bpaService;

    @GetMapping
    public ResponseEntity<List<BpaDTO>> findAll() {
        return ResponseEntity.ok(bpaService.findAll());
    }
}
