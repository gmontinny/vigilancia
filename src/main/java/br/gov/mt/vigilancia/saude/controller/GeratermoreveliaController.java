package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeratermoreveliaDTO;
import br.gov.mt.vigilancia.saude.service.GeratermoreveliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geratermorevelias")
public class GeratermoreveliaController {

    @Autowired
    private GeratermoreveliaService geratermoreveliaService;

    @GetMapping
    public ResponseEntity<List<GeratermoreveliaDTO>> getAllGeratermorevelias() {
        return ResponseEntity.ok(geratermoreveliaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeratermoreveliaDTO> getGeratermoreveliaById(@PathVariable Integer id) {
        return geratermoreveliaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeratermoreveliaDTO> createGeratermorevelia(@RequestBody GeratermoreveliaDTO geratermoreveliaDTO) {
        return ResponseEntity.ok(geratermoreveliaService.save(geratermoreveliaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeratermoreveliaDTO> updateGeratermorevelia(@PathVariable Integer id, @RequestBody GeratermoreveliaDTO geratermoreveliaDTO) {
        return geratermoreveliaService.findById(id)
                .map(existingGeratermoreveliaDTO -> {
                    geratermoreveliaDTO.setIdtermorevelia(id);
                    return ResponseEntity.ok(geratermoreveliaService.save(geratermoreveliaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeratermorevelia(@PathVariable Integer id) {
        geratermoreveliaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
