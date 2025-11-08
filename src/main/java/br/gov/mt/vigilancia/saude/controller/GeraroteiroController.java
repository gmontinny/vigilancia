package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraroteiroDTO;
import br.gov.mt.vigilancia.saude.service.GeraroteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geraroteiros")
public class GeraroteiroController {

    @Autowired
    private GeraroteiroService geraroteiroService;

    @GetMapping
    public ResponseEntity<List<GeraroteiroDTO>> getAllGeraroteiros() {
        return ResponseEntity.ok(geraroteiroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeraroteiroDTO> getGeraroteiroById(@PathVariable Integer id) {
        return geraroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeraroteiroDTO> createGeraroteiro(@RequestBody GeraroteiroDTO geraroteiroDTO) {
        return ResponseEntity.ok(geraroteiroService.save(geraroteiroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeraroteiroDTO> updateGeraroteiro(@PathVariable Integer id, @RequestBody GeraroteiroDTO geraroteiroDTO) {
        return geraroteiroService.findById(id)
                .map(existingGeraroteiroDTO -> {
                    geraroteiroDTO.setIdgeraroteiro(id);
                    return ResponseEntity.ok(geraroteiroService.save(geraroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeraroteiro(@PathVariable Integer id) {
        geraroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
