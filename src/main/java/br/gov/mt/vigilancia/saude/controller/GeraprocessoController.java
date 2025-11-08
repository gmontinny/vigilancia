package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeraprocessoDTO;
import br.gov.mt.vigilancia.saude.service.GeraprocessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geraprocessos")
public class GeraprocessoController {

    @Autowired
    private GeraprocessoService geraprocessoService;

    @GetMapping
    public ResponseEntity<List<GeraprocessoDTO>> getAllGeraprocessos() {
        return ResponseEntity.ok(geraprocessoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeraprocessoDTO> getGeraprocessoById(@PathVariable Integer id) {
        return geraprocessoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeraprocessoDTO> createGeraprocesso(@RequestBody GeraprocessoDTO geraprocessoDTO) {
        return ResponseEntity.ok(geraprocessoService.save(geraprocessoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeraprocessoDTO> updateGeraprocesso(@PathVariable Integer id, @RequestBody GeraprocessoDTO geraprocessoDTO) {
        return geraprocessoService.findById(id)
                .map(existingGeraprocessoDTO -> {
                    geraprocessoDTO.setIdprocesso(id);
                    return ResponseEntity.ok(geraprocessoService.save(geraprocessoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeraprocesso(@PathVariable Integer id) {
        geraprocessoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
