package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ServicosaudeDTO;
import br.gov.mt.vigilancia.saude.service.ServicosaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicosaudes")
public class ServicosaudeController {

    @Autowired
    private ServicosaudeService servicosaudeService;

    @GetMapping
    public ResponseEntity<List<ServicosaudeDTO>> getAllServicosaudes() {
        return ResponseEntity.ok(servicosaudeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicosaudeDTO> getServicosaudeById(@PathVariable Integer id) {
        return servicosaudeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServicosaudeDTO> createServicosaude(@RequestBody ServicosaudeDTO servicosaudeDTO) {
        return ResponseEntity.ok(servicosaudeService.save(servicosaudeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicosaudeDTO> updateServicosaude(@PathVariable Integer id, @RequestBody ServicosaudeDTO servicosaudeDTO) {
        return servicosaudeService.findById(id)
                .map(existingServicosaudeDTO -> {
                    servicosaudeDTO.setIdservicosaude(id);
                    return ResponseEntity.ok(servicosaudeService.save(servicosaudeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicosaude(@PathVariable Integer id) {
        servicosaudeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
