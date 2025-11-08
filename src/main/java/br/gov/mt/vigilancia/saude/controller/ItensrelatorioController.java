package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensrelatorioDTO;
import br.gov.mt.vigilancia.saude.service.ItensrelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensrelatorios")
public class ItensrelatorioController {

    @Autowired
    private ItensrelatorioService itensrelatorioService;

    @GetMapping
    public ResponseEntity<List<ItensrelatorioDTO>> getAllItensrelatorios() {
        return ResponseEntity.ok(itensrelatorioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensrelatorioDTO> getItensrelatorioById(@PathVariable Integer id) {
        return itensrelatorioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensrelatorioDTO> createItensrelatorio(@RequestBody ItensrelatorioDTO itensrelatorioDTO) {
        return ResponseEntity.ok(itensrelatorioService.save(itensrelatorioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensrelatorioDTO> updateItensrelatorio(@PathVariable Integer id, @RequestBody ItensrelatorioDTO itensrelatorioDTO) {
        return itensrelatorioService.findById(id)
                .map(existingItensrelatorioDTO -> {
                    itensrelatorioDTO.setIditensrelatorio(id);
                    return ResponseEntity.ok(itensrelatorioService.save(itensrelatorioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensrelatorio(@PathVariable Integer id) {
        itensrelatorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
