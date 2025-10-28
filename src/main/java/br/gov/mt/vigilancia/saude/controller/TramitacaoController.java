package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TramitacaoDTO;
import br.gov.mt.vigilancia.saude.service.TramitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tramitacoes")
public class TramitacaoController {

    @Autowired
    private TramitacaoService tramitacaoService;

    @GetMapping
    public ResponseEntity<List<TramitacaoDTO>> getAllTramitacoes() {
        return ResponseEntity.ok(tramitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramitacaoDTO> getTramitacaoById(@PathVariable Integer id) {
        return tramitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TramitacaoDTO> createTramitacao(@RequestBody TramitacaoDTO tramitacaoDTO) {
        return ResponseEntity.ok(tramitacaoService.save(tramitacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TramitacaoDTO> updateTramitacao(@PathVariable Integer id, @RequestBody TramitacaoDTO tramitacaoDTO) {
        return tramitacaoService.findById(id)
                .map(existingTramitacaoDTO -> {
                    tramitacaoDTO.setIdtramitacao(id);
                    return ResponseEntity.ok(tramitacaoService.save(tramitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTramitacao(@PathVariable Integer id) {
        tramitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
