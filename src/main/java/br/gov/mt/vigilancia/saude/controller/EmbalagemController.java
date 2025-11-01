package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EmbalagemDTO;
import br.gov.mt.vigilancia.saude.service.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/embalagens")
public class EmbalagemController {

    @Autowired
    private EmbalagemService embalagemService;

    @GetMapping
    public ResponseEntity<List<EmbalagemDTO>> getAllEmbalagens() {
        return ResponseEntity.ok(embalagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmbalagemDTO> getEmbalagemById(@PathVariable Integer id) {
        return embalagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmbalagemDTO> createEmbalagem(@RequestBody EmbalagemDTO embalagemDTO) {
        return ResponseEntity.ok(embalagemService.save(embalagemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmbalagemDTO> updateEmbalagem(@PathVariable Integer id, @RequestBody EmbalagemDTO embalagemDTO) {
        return embalagemService.findById(id)
                .map(existingEmbalagemDTO -> {
                    embalagemDTO.setIdembalagem(id);
                    return ResponseEntity.ok(embalagemService.save(embalagemDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmbalagem(@PathVariable Integer id) {
        embalagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
