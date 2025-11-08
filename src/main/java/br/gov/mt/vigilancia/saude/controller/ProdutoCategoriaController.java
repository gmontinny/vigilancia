package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProdutoCategoriaDTO;
import br.gov.mt.vigilancia.saude.service.ProdutoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtocategorias")
public class ProdutoCategoriaController {

    @Autowired
    private ProdutoCategoriaService produtocategoriaService;

    @GetMapping
    public ResponseEntity<List<ProdutoCategoriaDTO>> getAllProdutocategorias() {
        return ResponseEntity.ok(produtocategoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoCategoriaDTO> getProdutocategoriaById(@PathVariable Integer id) {
        return produtocategoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoCategoriaDTO> createProdutocategoria(@RequestBody ProdutoCategoriaDTO produtocategoriaDTO) {
        return ResponseEntity.ok(produtocategoriaService.save(produtocategoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoCategoriaDTO> updateProdutocategoria(@PathVariable Integer id, @RequestBody ProdutoCategoriaDTO produtocategoriaDTO) {
        return produtocategoriaService.findById(id)
                .map(existingProdutocategoriaDTO -> {
                    produtocategoriaDTO.setIdprodutocategoria(id);
                    return ResponseEntity.ok(produtocategoriaService.save(produtocategoriaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutocategoria(@PathVariable Integer id) {
        produtocategoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
