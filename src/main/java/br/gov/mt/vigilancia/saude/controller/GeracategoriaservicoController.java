package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeracategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.service.GeracategoriaservicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geracategoriaservicos")
public class GeracategoriaservicoController {

    @Autowired
    private GeracategoriaservicoService geracategoriaservicoService;

    @GetMapping
    public ResponseEntity<List<GeracategoriaservicoDTO>> getAllGeracategoriaservicos() {
        return ResponseEntity.ok(geracategoriaservicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeracategoriaservicoDTO> getGeracategoriaservicoById(@PathVariable Integer id) {
        return geracategoriaservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeracategoriaservicoDTO> createGeracategoriaservico(@RequestBody GeracategoriaservicoDTO geracategoriaservicoDTO) {
        return ResponseEntity.ok(geracategoriaservicoService.save(geracategoriaservicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeracategoriaservicoDTO> updateGeracategoriaservico(@PathVariable Integer id, @RequestBody GeracategoriaservicoDTO geracategoriaservicoDTO) {
        return geracategoriaservicoService.findById(id)
                .map(existingGeracategoriaservicoDTO -> {
                    geracategoriaservicoDTO.setIdgeracategoriaservico(id);
                    return ResponseEntity.ok(geracategoriaservicoService.save(geracategoriaservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeracategoriaservico(@PathVariable Integer id) {
        geracategoriaservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
