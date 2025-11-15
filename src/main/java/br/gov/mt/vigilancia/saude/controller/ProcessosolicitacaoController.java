package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessosolicitacaoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessosolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processosolicitacoes")
public class ProcessosolicitacaoController {

    @Autowired
    private ProcessosolicitacaoService processosolicitacaoService;

    @GetMapping
    public ResponseEntity<List<ProcessosolicitacaoDTO>> getAllProcessosolicitacoes() {
        return ResponseEntity.ok(processosolicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessosolicitacaoDTO> getProcessosolicitacaoById(@PathVariable Integer id) {
        return processosolicitacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProcessosolicitacaoDTO> createProcessosolicitacao(@RequestBody ProcessosolicitacaoDTO processosolicitacaoDTO) {
        return ResponseEntity.ok(processosolicitacaoService.save(processosolicitacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessosolicitacaoDTO> updateProcessosolicitacao(@PathVariable Integer id, @RequestBody ProcessosolicitacaoDTO processosolicitacaoDTO) {
        return processosolicitacaoService.findById(id)
                .map(existingProcessosolicitacaoDTO -> {
                    processosolicitacaoDTO.setIdprocessosolicitacao(id);
                    return ResponseEntity.ok(processosolicitacaoService.save(processosolicitacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessosolicitacao(@PathVariable Integer id) {
        processosolicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
