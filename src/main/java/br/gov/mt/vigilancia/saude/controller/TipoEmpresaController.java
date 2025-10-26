package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TipoEmpresaDTO;
import br.gov.mt.vigilancia.saude.service.TipoEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos-empresa")
@RequiredArgsConstructor
public class TipoEmpresaController {

    private final TipoEmpresaService tipoEmpresaService;

    @GetMapping
    public ResponseEntity<List<TipoEmpresaDTO>> findAll() {
        return ResponseEntity.ok(tipoEmpresaService.findAll());
    }
}
