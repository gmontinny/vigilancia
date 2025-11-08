package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TermocolheitaDTO;
import br.gov.mt.vigilancia.saude.service.TermocolheitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/termocolheitas")
public class TermocolheitaController {

    @Autowired
    private TermocolheitaService termocolheitaService;

    @GetMapping
    public ResponseEntity<List<TermocolheitaDTO>> getAllTermocolheitas() {
        return ResponseEntity.ok(termocolheitaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermocolheitaDTO> getTermocolheitaById(@PathVariable Integer id) {
        return termocolheitaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TermocolheitaDTO> createTermocolheita(@RequestBody TermocolheitaDTO termocolheitaDTO) {
        return ResponseEntity.ok(termocolheitaService.save(termocolheitaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TermocolheitaDTO> updateTermocolheita(@PathVariable Integer id, @RequestBody TermocolheitaDTO termocolheitaDTO) {
        return termocolheitaService.findById(id)
                .map(existingTermocolheitaDTO -> {
                    termocolheitaDTO.setIdtermocolheita(id);
                    return ResponseEntity.ok(termocolheitaService.save(termocolheitaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTermocolheita(@PathVariable Integer id) {
        termocolheitaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
