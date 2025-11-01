package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeradocumentoDTO;
import br.gov.mt.vigilancia.saude.service.GeradocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geradocumentos")
public class GeradocumentoController {

    @Autowired
    private GeradocumentoService geradocumentoService;

    @GetMapping
    public ResponseEntity<List<GeradocumentoDTO>> getAllGeradocumentos() {
        return ResponseEntity.ok(geradocumentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeradocumentoDTO> getGeradocumentoById(@PathVariable Integer id) {
        return geradocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeradocumentoDTO> createGeradocumento(@RequestBody GeradocumentoDTO geradocumentoDTO) {
        return ResponseEntity.ok(geradocumentoService.save(geradocumentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeradocumentoDTO> updateGeradocumento(@PathVariable Integer id, @RequestBody GeradocumentoDTO geradocumentoDTO) {
        return geradocumentoService.findById(id)
                .map(existingGeradocumentoDTO -> {
                    geradocumentoDTO.setIdgeradocumento(id);
                    return ResponseEntity.ok(geradocumentoService.save(geradocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeradocumento(@PathVariable Integer id) {
        geradocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
