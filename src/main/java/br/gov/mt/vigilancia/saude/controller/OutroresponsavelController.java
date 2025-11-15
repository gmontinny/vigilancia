package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.OutroresponsavelDTO;
import br.gov.mt.vigilancia.saude.service.OutroresponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outroresponsaveis")
public class OutroresponsavelController {

    @Autowired
    private OutroresponsavelService outroresponsavelService;

    @GetMapping
    public ResponseEntity<List<OutroresponsavelDTO>> getAllOutroresponsaveis() {
        return ResponseEntity.ok(outroresponsavelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutroresponsavelDTO> getOutroresponsavelById(@PathVariable Integer id) {
        return outroresponsavelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OutroresponsavelDTO> createOutroresponsavel(@RequestBody OutroresponsavelDTO outroresponsavelDTO) {
        return ResponseEntity.ok(outroresponsavelService.save(outroresponsavelDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutroresponsavelDTO> updateOutroresponsavel(@PathVariable Integer id, @RequestBody OutroresponsavelDTO outroresponsavelDTO) {
        return outroresponsavelService.findById(id)
                .map(existingOutroresponsavelDTO -> {
                    outroresponsavelDTO.setIdoutrosresponsaveis(id);
                    return ResponseEntity.ok(outroresponsavelService.save(outroresponsavelDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutroresponsavel(@PathVariable Integer id) {
        outroresponsavelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
