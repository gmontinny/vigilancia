package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaservicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaservicos")
public class CategoriaservicoController {

    @Autowired
    private CategoriaservicoService categoriaservicoService;

    @GetMapping
    public ResponseEntity<List<CategoriaservicoDTO>> getAllCategoriaservicos() {
        return ResponseEntity.ok(categoriaservicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaservicoDTO> getCategoriaservicoById(@PathVariable Integer id) {
        return categoriaservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaservicoDTO> createCategoriaservico(@RequestBody CategoriaservicoDTO categoriaservicoDTO) {
        return ResponseEntity.ok(categoriaservicoService.save(categoriaservicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaservicoDTO> updateCategoriaservico(@PathVariable Integer id, @RequestBody CategoriaservicoDTO categoriaservicoDTO) {
        return categoriaservicoService.findById(id)
                .map(existingCategoriaservicoDTO -> {
                    categoriaservicoDTO.setIdcategoriaservico(id);
                    return ResponseEntity.ok(categoriaservicoService.save(categoriaservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaservico(@PathVariable Integer id) {
        categoriaservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
