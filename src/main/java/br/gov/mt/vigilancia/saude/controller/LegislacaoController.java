package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LegislacaoDTO;
import br.gov.mt.vigilancia.saude.service.LegislacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legislacoes")
public class LegislacaoController {

    @Autowired
    private LegislacaoService legislacaoService;

    @GetMapping
    public ResponseEntity<List<LegislacaoDTO>> getAllLegislacoes() {
        return ResponseEntity.ok(legislacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegislacaoDTO> getLegislacaoById(@PathVariable Integer id) {
        return legislacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LegislacaoDTO> createLegislacao(@RequestBody LegislacaoDTO legislacaoDTO) {
        return ResponseEntity.ok(legislacaoService.save(legislacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegislacaoDTO> updateLegislacao(@PathVariable Integer id, @RequestBody LegislacaoDTO legislacaoDTO) {
        return legislacaoService.findById(id)
                .map(existingLegislacaoDTO -> {
                    legislacaoDTO.setIdlegislacao(id);
                    return ResponseEntity.ok(legislacaoService.save(legislacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegislacao(@PathVariable Integer id) {
        legislacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
