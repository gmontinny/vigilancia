package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TermonotificacaoDTO;
import br.gov.mt.vigilancia.saude.service.TermonotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/termonotificacoes")
public class TermonotificacaoController {

    @Autowired
    private TermonotificacaoService termonotificacaoService;

    @GetMapping
    public ResponseEntity<List<TermonotificacaoDTO>> getAllTermonotificacoes() {
        return ResponseEntity.ok(termonotificacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermonotificacaoDTO> getTermonotificacaoById(@PathVariable Integer id) {
        return termonotificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TermonotificacaoDTO> createTermonotificacao(@RequestBody TermonotificacaoDTO termonotificacaoDTO) {
        return ResponseEntity.ok(termonotificacaoService.save(termonotificacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TermonotificacaoDTO> updateTermonotificacao(@PathVariable Integer id, @RequestBody TermonotificacaoDTO termonotificacaoDTO) {
        return termonotificacaoService.findById(id)
                .map(existingTermonotificacaoDTO -> {
                    termonotificacaoDTO.setIdtermonotificacao(id);
                    return ResponseEntity.ok(termonotificacaoService.save(termonotificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTermonotificacao(@PathVariable Integer id) {
        termonotificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
