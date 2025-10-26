package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.PermissaoDTO;
import br.gov.mt.vigilancia.saude.service.PermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
@RequiredArgsConstructor
public class PermissaoController {

    private final PermissaoService permissaoService;

    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> findAll() {
        return ResponseEntity.ok(permissaoService.findAll());
    }
}
