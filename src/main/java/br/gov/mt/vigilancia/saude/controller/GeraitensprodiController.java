package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraitensprodiDTO;
import br.gov.mt.vigilancia.saude.service.GeraitensprodiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geraitensprodis")
public class GeraitensprodiController {

    @Autowired
    private GeraitensprodiService geraitensprodiService;

    @GetMapping
    public ResponseEntity<List<GeraitensprodiDTO>> getAllGeraitensprodis() {
        return ResponseEntity.ok(geraitensprodiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeraitensprodiDTO> getGeraitensprodiById(@PathVariable Integer id) {
        return geraitensprodiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeraitensprodiDTO> createGeraitensprodi(@RequestBody GeraitensprodiDTO geraitensprodiDTO) {
        return ResponseEntity.ok(geraitensprodiService.save(geraitensprodiDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeraitensprodiDTO> updateGeraitensprodi(@PathVariable Integer id, @RequestBody GeraitensprodiDTO geraitensprodiDTO) {
        return geraitensprodiService.findById(id)
                .map(existingGeraitensprodiDTO -> {
                    geraitensprodiDTO.setIdgeraitensprodi(id);
                    return ResponseEntity.ok(geraitensprodiService.save(geraitensprodiDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeraitensprodi(@PathVariable Integer id) {
        geraitensprodiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
