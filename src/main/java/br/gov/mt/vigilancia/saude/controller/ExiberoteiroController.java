package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ExiberoteiroDTO;
import br.gov.mt.vigilancia.saude.service.ExiberoteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exiberoteiros")
public class ExiberoteiroController {

    @Autowired
    private ExiberoteiroService exiberoteiroService;

    @GetMapping
    public ResponseEntity<List<ExiberoteiroDTO>> getAllExiberoteiros() {
        return ResponseEntity.ok(exiberoteiroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExiberoteiroDTO> getExiberoteiroById(@PathVariable Integer id) {
        return exiberoteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExiberoteiroDTO> createExiberoteiro(@RequestBody ExiberoteiroDTO exiberoteiroDTO) {
        return ResponseEntity.ok(exiberoteiroService.save(exiberoteiroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExiberoteiroDTO> updateExiberoteiro(@PathVariable Integer id, @RequestBody ExiberoteiroDTO exiberoteiroDTO) {
        return exiberoteiroService.findById(id)
                .map(existingExiberoteiroDTO -> {
                    exiberoteiroDTO.setIdexiberoteiro(id);
                    return ResponseEntity.ok(exiberoteiroService.save(exiberoteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExiberoteiro(@PathVariable Integer id) {
        exiberoteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
