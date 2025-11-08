package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensavaliacaoDTO;
import br.gov.mt.vigilancia.saude.service.ItensavaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensavaliacoes")
public class ItensavaliacaoController {

    @Autowired
    private ItensavaliacaoService itensavaliacaoService;

    @GetMapping
    public ResponseEntity<List<ItensavaliacaoDTO>> getAllItensavaliacoes() {
        return ResponseEntity.ok(itensavaliacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensavaliacaoDTO> getItensavaliacaoById(@PathVariable Integer id) {
        return itensavaliacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensavaliacaoDTO> createItensavaliacao(@RequestBody ItensavaliacaoDTO itensavaliacaoDTO) {
        return ResponseEntity.ok(itensavaliacaoService.save(itensavaliacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensavaliacaoDTO> updateItensavaliacao(@PathVariable Integer id, @RequestBody ItensavaliacaoDTO itensavaliacaoDTO) {
        return itensavaliacaoService.findById(id)
                .map(existingItensavaliacaoDTO -> {
                    itensavaliacaoDTO.setIditensavaliacao(id);
                    return ResponseEntity.ok(itensavaliacaoService.save(itensavaliacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensavaliacao(@PathVariable Integer id) {
        itensavaliacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
