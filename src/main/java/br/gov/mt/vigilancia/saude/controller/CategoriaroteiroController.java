package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaroteiroDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaroteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaroteiros")
public class CategoriaroteiroController {

    @Autowired
    private CategoriaroteiroService categoriaroteiroService;

    @GetMapping
    public ResponseEntity<List<CategoriaroteiroDTO>> getAllCategoriaroteiros() {
        return ResponseEntity.ok(categoriaroteiroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaroteiroDTO> getCategoriaroteiroById(@PathVariable Integer id) {
        return categoriaroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaroteiroDTO> createCategoriaroteiro(@RequestBody CategoriaroteiroDTO categoriaroteiroDTO) {
        return ResponseEntity.ok(categoriaroteiroService.save(categoriaroteiroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaroteiroDTO> updateCategoriaroteiro(@PathVariable Integer id, @RequestBody CategoriaroteiroDTO categoriaroteiroDTO) {
        return categoriaroteiroService.findById(id)
                .map(existingCategoriaroteiroDTO -> {
                    categoriaroteiroDTO.setIdcategoriaroteiro(id);
                    return ResponseEntity.ok(categoriaroteiroService.save(categoriaroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaroteiro(@PathVariable Integer id) {
        categoriaroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
