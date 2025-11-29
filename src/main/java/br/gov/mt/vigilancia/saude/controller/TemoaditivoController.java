package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TemoaditivoDTO;
import br.gov.mt.vigilancia.saude.service.TemoaditivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temoaditivos")
public class TemoaditivoController {

    @Autowired
    private TemoaditivoService temoaditivoService;

    @GetMapping
    public ResponseEntity<List<TemoaditivoDTO>> getAllTemoaditivos() {
        return ResponseEntity.ok(temoaditivoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemoaditivoDTO> getTemoaditivoById(@PathVariable Integer id) {
        return temoaditivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TemoaditivoDTO> createTemoaditivo(@RequestBody TemoaditivoDTO temoaditivoDTO) {
        return ResponseEntity.ok(temoaditivoService.save(temoaditivoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemoaditivoDTO> updateTemoaditivo(@PathVariable Integer id, @RequestBody TemoaditivoDTO temoaditivoDTO) {
        return temoaditivoService.findById(id)
                .map(existingTemoaditivoDTO -> {
                    temoaditivoDTO.setIdtermoaditivo(id);
                    return ResponseEntity.ok(temoaditivoService.save(temoaditivoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemoaditivo(@PathVariable Integer id) {
        temoaditivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
