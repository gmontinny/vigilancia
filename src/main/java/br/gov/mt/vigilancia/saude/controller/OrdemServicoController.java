package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import br.gov.mt.vigilancia.saude.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
@RequiredArgsConstructor
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> findAll() {
        return ResponseEntity.ok(ordemServicoService.findAll());
    }
}
