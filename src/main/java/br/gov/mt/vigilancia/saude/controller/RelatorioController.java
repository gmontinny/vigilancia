package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RelatorioDTO;
import br.gov.mt.vigilancia.saude.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
    public ResponseEntity<List<RelatorioDTO>> getAllRelatorios() {
        return ResponseEntity.ok(relatorioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelatorioDTO> getRelatorioById(@PathVariable Integer id) {
        return relatorioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RelatorioDTO> createRelatorio(@RequestBody RelatorioDTO relatorioDTO) {
        return ResponseEntity.ok(relatorioService.save(relatorioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelatorioDTO> updateRelatorio(@PathVariable Integer id, @RequestBody RelatorioDTO relatorioDTO) {
        return relatorioService.findById(id)
                .map(existingRelatorioDTO -> {
                    relatorioDTO.setIdrelatorio(id);
                    return ResponseEntity.ok(relatorioService.save(relatorioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelatorio(@PathVariable Integer id) {
        relatorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
