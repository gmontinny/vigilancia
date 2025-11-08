package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeratramiteDTO;
import br.gov.mt.vigilancia.saude.service.GeratramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geratramites")
public class GeratramiteController {

    @Autowired
    private GeratramiteService geratramiteService;

    @GetMapping
    public ResponseEntity<List<GeratramiteDTO>> getAllGeratramites() {
        return ResponseEntity.ok(geratramiteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeratramiteDTO> getGeratramiteById(@PathVariable Integer id) {
        return geratramiteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeratramiteDTO> createGeratramite(@RequestBody GeratramiteDTO geratramiteDTO) {
        return ResponseEntity.ok(geratramiteService.save(geratramiteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeratramiteDTO> updateGeratramite(@PathVariable Integer id, @RequestBody GeratramiteDTO geratramiteDTO) {
        return geratramiteService.findById(id)
                .map(existingGeratramiteDTO -> {
                    geratramiteDTO.setIdgeratramite(id);
                    return ResponseEntity.ok(geratramiteService.save(geratramiteDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeratramite(@PathVariable Integer id) {
        geratramiteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
