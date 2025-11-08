package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensexiberoteiroDTO;
import br.gov.mt.vigilancia.saude.service.ItensexiberoteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensexiberoteiros")
public class ItensexiberoteiroController {

    @Autowired
    private ItensexiberoteiroService itensexiberoteiroService;

    @GetMapping
    public ResponseEntity<List<ItensexiberoteiroDTO>> getAllItensexiberoteiros() {
        return ResponseEntity.ok(itensexiberoteiroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensexiberoteiroDTO> getItensexiberoteiroById(@PathVariable Integer id) {
        return itensexiberoteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensexiberoteiroDTO> createItensexiberoteiro(@RequestBody ItensexiberoteiroDTO itensexiberoteiroDTO) {
        return ResponseEntity.ok(itensexiberoteiroService.save(itensexiberoteiroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensexiberoteiroDTO> updateItensexiberoteiro(@PathVariable Integer id, @RequestBody ItensexiberoteiroDTO itensexiberoteiroDTO) {
        return itensexiberoteiroService.findById(id)
                .map(existingItensexiberoteiroDTO -> {
                    itensexiberoteiroDTO.setIditensexiberoteiro(id);
                    return ResponseEntity.ok(itensexiberoteiroService.save(itensexiberoteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensexiberoteiro(@PathVariable Integer id) {
        itensexiberoteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
