package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.SolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoDTO>> getAllSolicitacoes() {
        return ResponseEntity.ok(solicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoDTO> getSolicitacaoById(@PathVariable Integer id) {
        return solicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SolicitacaoDTO> createSolicitacao(@RequestBody SolicitacaoDTO solicitacaoDTO) {
        return ResponseEntity.ok(solicitacaoService.save(solicitacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitacaoDTO> updateSolicitacao(@PathVariable Integer id, @RequestBody SolicitacaoDTO solicitacaoDTO) {
        return solicitacaoService.findById(id)
                .map(existingSolicitacaoDTO -> {
                    solicitacaoDTO.setIdsolicitacao(id);
                    return ResponseEntity.ok(solicitacaoService.save(solicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitacao(@PathVariable Integer id) {
        solicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
