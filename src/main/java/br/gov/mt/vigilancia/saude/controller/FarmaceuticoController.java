package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FarmaceuticoDTO;
import br.gov.mt.vigilancia.saude.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmaceuticos")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @GetMapping
    public ResponseEntity<List<FarmaceuticoDTO>> getAllFarmaceuticos() {
        return ResponseEntity.ok(farmaceuticoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmaceuticoDTO> getFarmaceuticoById(@PathVariable Integer id) {
        return farmaceuticoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FarmaceuticoDTO> createFarmaceutico(@RequestBody FarmaceuticoDTO farmaceuticoDTO) {
        return ResponseEntity.ok(farmaceuticoService.save(farmaceuticoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmaceuticoDTO> updateFarmaceutico(@PathVariable Integer id, @RequestBody FarmaceuticoDTO farmaceuticoDTO) {
        return farmaceuticoService.findById(id)
                .map(existingFarmaceuticoDTO -> {
                    farmaceuticoDTO.setIdfarmaceuticos(id);
                    return ResponseEntity.ok(farmaceuticoService.save(farmaceuticoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmaceutico(@PathVariable Integer id) {
        farmaceuticoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
