package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItenscolheitaDTO;
import br.gov.mt.vigilancia.saude.service.ItenscolheitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itenscolheitas")
public class ItenscolheitaController {

    @Autowired
    private ItenscolheitaService itenscolheitaService;

    @GetMapping
    public ResponseEntity<List<ItenscolheitaDTO>> getAllItenscolheitas() {
        return ResponseEntity.ok(itenscolheitaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItenscolheitaDTO> getItenscolheitaById(@PathVariable Integer id) {
        return itenscolheitaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItenscolheitaDTO> createItenscolheita(@RequestBody ItenscolheitaDTO itenscolheitaDTO) {
        return ResponseEntity.ok(itenscolheitaService.save(itenscolheitaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItenscolheitaDTO> updateItenscolheita(@PathVariable Integer id, @RequestBody ItenscolheitaDTO itenscolheitaDTO) {
        return itenscolheitaService.findById(id)
                .map(existingItenscolheitaDTO -> {
                    itenscolheitaDTO.setIditenscolheita(id);
                    return ResponseEntity.ok(itenscolheitaService.save(itenscolheitaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItenscolheita(@PathVariable Integer id) {
        itenscolheitaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
