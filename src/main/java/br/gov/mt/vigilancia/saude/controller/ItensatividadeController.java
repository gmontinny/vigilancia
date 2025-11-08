package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensatividadeDTO;
import br.gov.mt.vigilancia.saude.service.ItensatividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensatividades")
public class ItensatividadeController {

    @Autowired
    private ItensatividadeService itensatividadeService;

    @GetMapping
    public ResponseEntity<List<ItensatividadeDTO>> getAllItensatividades() {
        return ResponseEntity.ok(itensatividadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensatividadeDTO> getItensatividadeById(@PathVariable Integer id) {
        return itensatividadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensatividadeDTO> createItensatividade(@RequestBody ItensatividadeDTO itensatividadeDTO) {
        return ResponseEntity.ok(itensatividadeService.save(itensatividadeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensatividadeDTO> updateItensatividade(@PathVariable Integer id, @RequestBody ItensatividadeDTO itensatividadeDTO) {
        return itensatividadeService.findById(id)
                .map(existingItensatividadeDTO -> {
                    itensatividadeDTO.setIditensatividade(id);
                    return ResponseEntity.ok(itensatividadeService.save(itensatividadeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensatividade(@PathVariable Integer id) {
        itensatividadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
