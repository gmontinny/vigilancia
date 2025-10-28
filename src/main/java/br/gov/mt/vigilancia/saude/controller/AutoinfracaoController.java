package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AutoinfracaoDTO;
import br.gov.mt.vigilancia.saude.service.AutoinfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoinfracoes")
public class AutoinfracaoController {

    @Autowired
    private AutoinfracaoService autoinfracaoService;

    @GetMapping
    public ResponseEntity<List<AutoinfracaoDTO>> getAllAutoinfracoes() {
        return ResponseEntity.ok(autoinfracaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoinfracaoDTO> getAutoinfracaoById(@PathVariable Integer id) {
        return autoinfracaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AutoinfracaoDTO> createAutoinfracao(@RequestBody AutoinfracaoDTO autoinfracaoDTO) {
        return ResponseEntity.ok(autoinfracaoService.save(autoinfracaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoinfracaoDTO> updateAutoinfracao(@PathVariable Integer id, @RequestBody AutoinfracaoDTO autoinfracaoDTO) {
        return autoinfracaoService.findById(id)
                .map(existingAutoinfracaoDTO -> {
                    autoinfracaoDTO.setIdautoinfracao(id);
                    return ResponseEntity.ok(autoinfracaoService.save(autoinfracaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutoinfracao(@PathVariable Integer id) {
        autoinfracaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
