package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TermoreveliaDTO;
import br.gov.mt.vigilancia.saude.service.TermoreveliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/termorevelias")
public class TermoreveliaController {

    @Autowired
    private TermoreveliaService termoreveliaService;

    @GetMapping
    public ResponseEntity<List<TermoreveliaDTO>> getAllTermorevelias() {
        return ResponseEntity.ok(termoreveliaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermoreveliaDTO> getTermoreveliaById(@PathVariable Integer id) {
        return termoreveliaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TermoreveliaDTO> createTermorevelia(@RequestBody TermoreveliaDTO termoreveliaDTO) {
        return ResponseEntity.ok(termoreveliaService.save(termoreveliaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TermoreveliaDTO> updateTermorevelia(@PathVariable Integer id, @RequestBody TermoreveliaDTO termoreveliaDTO) {
        return termoreveliaService.findById(id)
                .map(existingTermoreveliaDTO -> {
                    termoreveliaDTO.setIdtermorevelia(id);
                    return ResponseEntity.ok(termoreveliaService.save(termoreveliaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTermorevelia(@PathVariable Integer id) {
        termoreveliaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
