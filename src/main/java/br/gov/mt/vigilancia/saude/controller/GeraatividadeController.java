package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraatividadeDTO;
import br.gov.mt.vigilancia.saude.service.GeraatividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geraatividades")
public class GeraatividadeController {

    @Autowired
    private GeraatividadeService geraatividadeService;

    @GetMapping
    public ResponseEntity<List<GeraatividadeDTO>> getAllGeraatividades() {
        return ResponseEntity.ok(geraatividadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeraatividadeDTO> getGeraatividadeById(@PathVariable Integer id) {
        return geraatividadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeraatividadeDTO> createGeraatividade(@RequestBody GeraatividadeDTO geraatividadeDTO) {
        return ResponseEntity.ok(geraatividadeService.save(geraatividadeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeraatividadeDTO> updateGeraatividade(@PathVariable Integer id, @RequestBody GeraatividadeDTO geraatividadeDTO) {
        return geraatividadeService.findById(id)
                .map(existingGeraatividadeDTO -> {
                    geraatividadeDTO.setIdgeraatividade(id);
                    return ResponseEntity.ok(geraatividadeService.save(geraatividadeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeraatividade(@PathVariable Integer id) {
        geraatividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
