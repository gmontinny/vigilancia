package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AnaliseprocessoDTO;
import br.gov.mt.vigilancia.saude.service.AnaliseprocessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analiseprocessos")
public class AnaliseprocessoController {

    @Autowired
    private AnaliseprocessoService analiseprocessoService;

    @GetMapping
    public ResponseEntity<List<AnaliseprocessoDTO>> getAllAnaliseprocessos() {
        return ResponseEntity.ok(analiseprocessoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnaliseprocessoDTO> getAnaliseprocessoById(@PathVariable Integer id) {
        return analiseprocessoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AnaliseprocessoDTO> createAnaliseprocesso(@RequestBody AnaliseprocessoDTO analiseprocessoDTO) {
        return ResponseEntity.ok(analiseprocessoService.save(analiseprocessoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnaliseprocessoDTO> updateAnaliseprocesso(@PathVariable Integer id, @RequestBody AnaliseprocessoDTO analiseprocessoDTO) {
        return analiseprocessoService.findById(id)
                .map(existingAnaliseprocessoDTO -> {
                    analiseprocessoDTO.setIdanaliseprocesso(id);
                    return ResponseEntity.ok(analiseprocessoService.save(analiseprocessoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnaliseprocesso(@PathVariable Integer id) {
        analiseprocessoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
