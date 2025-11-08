package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensembalagemDTO;
import br.gov.mt.vigilancia.saude.service.ItensembalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensembalagens")
public class ItensembalagemController {

    @Autowired
    private ItensembalagemService itensembalagemService;

    @GetMapping
    public ResponseEntity<List<ItensembalagemDTO>> getAllItensembalagens() {
        return ResponseEntity.ok(itensembalagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensembalagemDTO> getItensembalagemById(@PathVariable Integer id) {
        return itensembalagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensembalagemDTO> createItensembalagem(@RequestBody ItensembalagemDTO itensembalagemDTO) {
        return ResponseEntity.ok(itensembalagemService.save(itensembalagemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensembalagemDTO> updateItensembalagem(@PathVariable Integer id, @RequestBody ItensembalagemDTO itensembalagemDTO) {
        return itensembalagemService.findById(id)
                .map(existingItensembalagemDTO -> {
                    itensembalagemDTO.setIditensembalagem(id);
                    return ResponseEntity.ok(itensembalagemService.save(itensembalagemDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensembalagem(@PathVariable Integer id) {
        itensembalagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
