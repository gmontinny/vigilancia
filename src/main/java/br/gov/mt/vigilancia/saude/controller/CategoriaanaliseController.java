package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaanaliseDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaanaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaanalises")
public class CategoriaanaliseController {

    @Autowired
    private CategoriaanaliseService categoriaanaliseService;

    @GetMapping
    public ResponseEntity<List<CategoriaanaliseDTO>> getAllCategoriaanalises() {
        return ResponseEntity.ok(categoriaanaliseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaanaliseDTO> getCategoriaanaliseById(@PathVariable Integer id) {
        return categoriaanaliseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaanaliseDTO> createCategoriaanalise(@RequestBody CategoriaanaliseDTO categoriaanaliseDTO) {
        return ResponseEntity.ok(categoriaanaliseService.save(categoriaanaliseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaanaliseDTO> updateCategoriaanalise(@PathVariable Integer id, @RequestBody CategoriaanaliseDTO categoriaanaliseDTO) {
        return categoriaanaliseService.findById(id)
                .map(existingCategoriaanaliseDTO -> {
                    categoriaanaliseDTO.setIdcategoriaanalise(id);
                    return ResponseEntity.ok(categoriaanaliseService.save(categoriaanaliseDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaanalise(@PathVariable Integer id) {
        categoriaanaliseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
