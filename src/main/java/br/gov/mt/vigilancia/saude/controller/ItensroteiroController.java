package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensroteiroDTO;
import br.gov.mt.vigilancia.saude.service.ItensroteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensroteiros")
public class ItensroteiroController {

    @Autowired
    private ItensroteiroService itensroteiroService;

    @GetMapping
    public ResponseEntity<List<ItensroteiroDTO>> getAllItensroteiros() {
        return ResponseEntity.ok(itensroteiroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensroteiroDTO> getItensroteiroById(@PathVariable Integer id) {
        return itensroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensroteiroDTO> createItensroteiro(@RequestBody ItensroteiroDTO itensroteiroDTO) {
        return ResponseEntity.ok(itensroteiroService.save(itensroteiroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensroteiroDTO> updateItensroteiro(@PathVariable Integer id, @RequestBody ItensroteiroDTO itensroteiroDTO) {
        return itensroteiroService.findById(id)
                .map(existingItensroteiroDTO -> {
                    itensroteiroDTO.setIditensroteiro(id);
                    return ResponseEntity.ok(itensroteiroService.save(itensroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensroteiro(@PathVariable Integer id) {
        itensroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
