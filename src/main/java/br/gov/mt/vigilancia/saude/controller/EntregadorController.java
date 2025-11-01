package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EntregadorDTO;
import br.gov.mt.vigilancia.saude.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public ResponseEntity<List<EntregadorDTO>> getAllEntregadores() {
        return ResponseEntity.ok(entregadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregadorDTO> getEntregadorById(@PathVariable Integer id) {
        return entregadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntregadorDTO> createEntregador(@RequestBody EntregadorDTO entregadorDTO) {
        return ResponseEntity.ok(entregadorService.save(entregadorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregadorDTO> updateEntregador(@PathVariable Integer id, @RequestBody EntregadorDTO entregadorDTO) {
        return entregadorService.findById(id)
                .map(existingEntregadorDTO -> {
                    entregadorDTO.setIdentregador(id);
                    return ResponseEntity.ok(entregadorService.save(entregadorDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntregador(@PathVariable Integer id) {
        entregadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
