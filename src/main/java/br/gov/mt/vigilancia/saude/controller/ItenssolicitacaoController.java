package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItenssolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.ItenssolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itenssolicitacoes")
public class ItenssolicitacaoController {

    @Autowired
    private ItenssolicitacaoService itenssolicitacaoService;

    @GetMapping
    public ResponseEntity<List<ItenssolicitacaoDTO>> getAllItenssolicitacoes() {
        return ResponseEntity.ok(itenssolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItenssolicitacaoDTO> getItenssolicitacaoById(@PathVariable Integer id) {
        return itenssolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItenssolicitacaoDTO> createItenssolicitacao(@RequestBody ItenssolicitacaoDTO itenssolicitacaoDTO) {
        return ResponseEntity.ok(itenssolicitacaoService.save(itenssolicitacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItenssolicitacaoDTO> updateItenssolicitacao(@PathVariable Integer id, @RequestBody ItenssolicitacaoDTO itenssolicitacaoDTO) {
        return itenssolicitacaoService.findById(id)
                .map(existingItenssolicitacaoDTO -> {
                    itenssolicitacaoDTO.setIditenssolicitacao(id);
                    return ResponseEntity.ok(itenssolicitacaoService.save(itenssolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItenssolicitacao(@PathVariable Integer id) {
        itenssolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
