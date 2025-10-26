package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ArquitetonicoDTO;
import br.gov.mt.vigilancia.saude.service.ArquitetonicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arquitetonicos")
public class ArquitetonicoController {

    @Autowired
    private ArquitetonicoService arquitetonicoService;

    @GetMapping
    public ResponseEntity<List<ArquitetonicoDTO>> getAllArquitetonicos() {
        return ResponseEntity.ok(arquitetonicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArquitetonicoDTO> getArquitetonicoById(@PathVariable Integer id) {
        return arquitetonicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArquitetonicoDTO> createArquitetonico(@RequestBody ArquitetonicoDTO arquitetonicoDTO) {
        return ResponseEntity.ok(arquitetonicoService.save(arquitetonicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArquitetonicoDTO> updateArquitetonico(@PathVariable Integer id, @RequestBody ArquitetonicoDTO arquitetonicoDTO) {
        return arquitetonicoService.findById(id)
                .map(existingArquitetonicoDTO -> {
                    arquitetonicoDTO.setIdarquitetonicos(id);
                    return ResponseEntity.ok(arquitetonicoService.save(arquitetonicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArquitetonico(@PathVariable Integer id) {
        arquitetonicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
