package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import br.gov.mt.vigilancia.saude.service.ProdutoCategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos-categoria")
@RequiredArgsConstructor
public class ProdutoCategoriaController {

    private final ProdutoCategoriaService produtoCategoriaService;

    @GetMapping
    public ResponseEntity<List<ProdutoCategoriaDTO>> findAll() {
        return ResponseEntity.ok(produtoCategoriaService.findAll());
    }
}
