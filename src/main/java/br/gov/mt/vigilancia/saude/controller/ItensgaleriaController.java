package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensgaleriaDTO;
import br.gov.mt.vigilancia.saude.service.ItensgaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensgalerias")
public class ItensgaleriaController {

    @Autowired
    private ItensgaleriaService itensgaleriaService;

    @GetMapping
    public ResponseEntity<List<ItensgaleriaDTO>> getAllItensgalerias() {
        return ResponseEntity.ok(itensgaleriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensgaleriaDTO> getItensgaleriaById(@PathVariable Integer id) {
        return itensgaleriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensgaleriaDTO> createItensgaleria(@RequestBody ItensgaleriaDTO itensgaleriaDTO) {
        return ResponseEntity.ok(itensgaleriaService.save(itensgaleriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensgaleriaDTO> updateItensgaleria(@PathVariable Integer id, @RequestBody ItensgaleriaDTO itensgaleriaDTO) {
        return itensgaleriaService.findById(id)
                .map(existingItensgaleriaDTO -> {
                    itensgaleriaDTO.setIditensgaleria(id);
                    return ResponseEntity.ok(itensgaleriaService.save(itensgaleriaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensgaleria(@PathVariable Integer id) {
        itensgaleriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
