package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CategoriaprodutoDTO;
import br.gov.mt.vigilancia.saude.service.CategoriaprodutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaprodutos")
public class CategoriaprodutoController {

    @Autowired
    private CategoriaprodutoService categoriaprodutoService;

    @GetMapping
    public ResponseEntity<List<CategoriaprodutoDTO>> getAllCategoriaprodutos() {
        return ResponseEntity.ok(categoriaprodutoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaprodutoDTO> getCategoriaprodutoById(@PathVariable Integer id) {
        return categoriaprodutoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaprodutoDTO> createCategoriaproduto(@RequestBody CategoriaprodutoDTO categoriaprodutoDTO) {
        return ResponseEntity.ok(categoriaprodutoService.save(categoriaprodutoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaprodutoDTO> updateCategoriaproduto(@PathVariable Integer id, @RequestBody CategoriaprodutoDTO categoriaprodutoDTO) {
        return categoriaprodutoService.findById(id)
                .map(existingCategoriaprodutoDTO -> {
                    categoriaprodutoDTO.setIdcategoriaproduto(id);
                    return ResponseEntity.ok(categoriaprodutoService.save(categoriaprodutoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaproduto(@PathVariable Integer id) {
        categoriaprodutoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
