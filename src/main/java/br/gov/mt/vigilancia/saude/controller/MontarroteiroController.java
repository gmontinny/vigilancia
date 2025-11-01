package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MontarroteiroDTO;
import br.gov.mt.vigilancia.saude.service.MontarroteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/montarroteiros")
public class MontarroteiroController {

    @Autowired
    private MontarroteiroService montarroteiroService;

    @GetMapping
    public ResponseEntity<List<MontarroteiroDTO>> getAllMontarroteiros() {
        return ResponseEntity.ok(montarroteiroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MontarroteiroDTO> getMontarroteiroById(@PathVariable Integer id) {
        return montarroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MontarroteiroDTO> createMontarroteiro(@RequestBody MontarroteiroDTO montarroteiroDTO) {
        return ResponseEntity.ok(montarroteiroService.save(montarroteiroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MontarroteiroDTO> updateMontarroteiro(@PathVariable Integer id, @RequestBody MontarroteiroDTO montarroteiroDTO) {
        return montarroteiroService.findById(id)
                .map(existingMontarroteiroDTO -> {
                    montarroteiroDTO.setIdmontarroteiro(id);
                    return ResponseEntity.ok(montarroteiroService.save(montarroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMontarroteiro(@PathVariable Integer id) {
        montarroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
