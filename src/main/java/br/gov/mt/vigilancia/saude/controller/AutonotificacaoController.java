package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AutonotificacaoDTO;
import br.gov.mt.vigilancia.saude.service.AutonotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autonotificacoes")
public class AutonotificacaoController {

    @Autowired
    private AutonotificacaoService autonotificacaoService;

    @GetMapping
    public ResponseEntity<List<AutonotificacaoDTO>> getAllAutonotificacoes() {
        return ResponseEntity.ok(autonotificacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutonotificacaoDTO> getAutonotificacaoById(@PathVariable Integer id) {
        return autonotificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AutonotificacaoDTO> createAutonotificacao(@RequestBody AutonotificacaoDTO autonotificacaoDTO) {
        return ResponseEntity.ok(autonotificacaoService.save(autonotificacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutonotificacaoDTO> updateAutonotificacao(@PathVariable Integer id, @RequestBody AutonotificacaoDTO autonotificacaoDTO) {
        return autonotificacaoService.findById(id)
                .map(existingAutonotificacaoDTO -> {
                    autonotificacaoDTO.setIdautonotificacao(id);
                    return ResponseEntity.ok(autonotificacaoService.save(autonotificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutonotificacao(@PathVariable Integer id) {
        autonotificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
