package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RetinoicoDTO;
import br.gov.mt.vigilancia.saude.service.RetinoicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retinoicos")
public class RetinoicoController {

    @Autowired
    private RetinoicoService retinoicoService;

    @GetMapping
    public ResponseEntity<List<RetinoicoDTO>> getAllRetinoicos() {
        return ResponseEntity.ok(retinoicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RetinoicoDTO> getRetinoicoById(@PathVariable Integer id) {
        return retinoicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RetinoicoDTO> createRetinoico(@RequestBody RetinoicoDTO retinoicoDTO) {
        return ResponseEntity.ok(retinoicoService.save(retinoicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetinoicoDTO> updateRetinoico(@PathVariable Integer id, @RequestBody RetinoicoDTO retinoicoDTO) {
        return retinoicoService.findById(id)
                .map(existingRetinoicoDTO -> {
                    retinoicoDTO.setIdretinoico(id);
                    return ResponseEntity.ok(retinoicoService.save(retinoicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetinoico(@PathVariable Integer id) {
        retinoicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
