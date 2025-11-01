package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeragaleriaDTO;
import br.gov.mt.vigilancia.saude.service.GeragaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geragalerias")
public class GeragaleriaController {

    @Autowired
    private GeragaleriaService geragaleriaService;

    @GetMapping
    public ResponseEntity<List<GeragaleriaDTO>> getAllGeragalerias() {
        return ResponseEntity.ok(geragaleriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeragaleriaDTO> getGeragaleriaById(@PathVariable Integer id) {
        return geragaleriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeragaleriaDTO> createGeragaleria(@RequestBody GeragaleriaDTO geragaleriaDTO) {
        return ResponseEntity.ok(geragaleriaService.save(geragaleriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeragaleriaDTO> updateGeragaleria(@PathVariable Integer id, @RequestBody GeragaleriaDTO geragaleriaDTO) {
        return geragaleriaService.findById(id)
                .map(existingGeragaleriaDTO -> {
                    geragaleriaDTO.setIdgeragaleria(id);
                    return ResponseEntity.ok(geragaleriaService.save(geragaleriaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeragaleria(@PathVariable Integer id) {
        geragaleriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
