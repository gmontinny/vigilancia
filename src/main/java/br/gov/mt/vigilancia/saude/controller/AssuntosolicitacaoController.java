package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AssuntosolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.AssuntosolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assuntosolicitacoes")
public class AssuntosolicitacaoController {

    @Autowired
    private AssuntosolicitacaoService assuntosolicitacaoService;

    @GetMapping
    public ResponseEntity<List<AssuntosolicitacaoDTO>> getAllAssuntosolicitacoes() {
        return ResponseEntity.ok(assuntosolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuntosolicitacaoDTO> getAssuntosolicitacaoById(@PathVariable Integer id) {
        return assuntosolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AssuntosolicitacaoDTO> createAssuntosolicitacao(@RequestBody AssuntosolicitacaoDTO assuntosolicitacaoDTO) {
        return ResponseEntity.ok(assuntosolicitacaoService.save(assuntosolicitacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssuntosolicitacaoDTO> updateAssuntosolicitacao(@PathVariable Integer id, @RequestBody AssuntosolicitacaoDTO assuntosolicitacaoDTO) {
        return assuntosolicitacaoService.findById(id)
                .map(existingAssuntosolicitacaoDTO -> {
                    assuntosolicitacaoDTO.setIdassunto(id);
                    return ResponseEntity.ok(assuntosolicitacaoService.save(assuntosolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssuntosolicitacao(@PathVariable Integer id) {
        assuntosolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
