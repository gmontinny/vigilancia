package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GestaodocumentoDTO;
import br.gov.mt.vigilancia.saude.service.GestaodocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestaodocumentos")
public class GestaodocumentoController {

    @Autowired
    private GestaodocumentoService gestaodocumentoService;

    @GetMapping
    public ResponseEntity<List<GestaodocumentoDTO>> getAllGestaodocumentos() {
        return ResponseEntity.ok(gestaodocumentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GestaodocumentoDTO> getGestaodocumentoById(@PathVariable Integer id) {
        return gestaodocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GestaodocumentoDTO> createGestaodocumento(@RequestBody GestaodocumentoDTO gestaodocumentoDTO) {
        return ResponseEntity.ok(gestaodocumentoService.save(gestaodocumentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GestaodocumentoDTO> updateGestaodocumento(@PathVariable Integer id, @RequestBody GestaodocumentoDTO gestaodocumentoDTO) {
        return gestaodocumentoService.findById(id)
                .map(existingGestaodocumentoDTO -> {
                    gestaodocumentoDTO.setIdgestaodocumento(id);
                    return ResponseEntity.ok(gestaodocumentoService.save(gestaodocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGestaodocumento(@PathVariable Integer id) {
        gestaodocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
