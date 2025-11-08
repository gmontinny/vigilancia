package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensautoinfracaoDTO;
import br.gov.mt.vigilancia.saude.service.ItensautoinfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensautoinfracoes")
public class ItensautoinfracaoController {

    @Autowired
    private ItensautoinfracaoService itensautoinfracaoService;

    @GetMapping
    public ResponseEntity<List<ItensautoinfracaoDTO>> getAllItensautoinfracoes() {
        return ResponseEntity.ok(itensautoinfracaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensautoinfracaoDTO> getItensautoinfracaoById(@PathVariable Integer id) {
        return itensautoinfracaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensautoinfracaoDTO> createItensautoinfracao(@RequestBody ItensautoinfracaoDTO itensautoinfracaoDTO) {
        return ResponseEntity.ok(itensautoinfracaoService.save(itensautoinfracaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensautoinfracaoDTO> updateItensautoinfracao(@PathVariable Integer id, @RequestBody ItensautoinfracaoDTO itensautoinfracaoDTO) {
        return itensautoinfracaoService.findById(id)
                .map(existingItensautoinfracaoDTO -> {
                    itensautoinfracaoDTO.setIditensautoinfracao(id);
                    return ResponseEntity.ok(itensautoinfracaoService.save(itensautoinfracaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensautoinfracao(@PathVariable Integer id) {
        itensautoinfracaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
