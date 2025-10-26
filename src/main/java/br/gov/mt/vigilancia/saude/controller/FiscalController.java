package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FiscalDTO;
import br.gov.mt.vigilancia.saude.service.FiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fiscais")
@RequiredArgsConstructor
public class FiscalController {

    private final FiscalService fiscalService;

    @GetMapping
    public ResponseEntity<List<FiscalDTO>> findAll() {
        return ResponseEntity.ok(fiscalService.findAll());
    }
}
