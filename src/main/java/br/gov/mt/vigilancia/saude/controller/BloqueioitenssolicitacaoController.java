package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BloqueioitenssolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.BloqueioitenssolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloqueioitenssolicitacoes")
public class BloqueioitenssolicitacaoController {

    @Autowired
    private BloqueioitenssolicitacaoService bloqueioitenssolicitacaoService;

    @GetMapping
    public ResponseEntity<List<BloqueioitenssolicitacaoDTO>> getAllBloqueioitenssolicitacoes() {
        return ResponseEntity.ok(bloqueioitenssolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloqueioitenssolicitacaoDTO> getBloqueioitenssolicitacaoById(@PathVariable Integer id) {
        return bloqueioitenssolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BloqueioitenssolicitacaoDTO> createBloqueioitenssolicitacao(@RequestBody BloqueioitenssolicitacaoDTO bloqueioitenssolicitacaoDTO) {
        return ResponseEntity.ok(bloqueioitenssolicitacaoService.save(bloqueioitenssolicitacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloqueioitenssolicitacaoDTO> updateBloqueioitenssolicitacao(@PathVariable Integer id, @RequestBody BloqueioitenssolicitacaoDTO bloqueioitenssolicitacaoDTO) {
        return bloqueioitenssolicitacaoService.findById(id)
                .map(existingBloqueioitenssolicitacaoDTO -> {
                    bloqueioitenssolicitacaoDTO.setIdbloqueioitenssolicitacao(id);
                    return ResponseEntity.ok(bloqueioitenssolicitacaoService.save(bloqueioitenssolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloqueioitenssolicitacao(@PathVariable Integer id) {
        bloqueioitenssolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
