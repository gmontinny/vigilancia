package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.GeracodigocertificacaoDTO;
import br.gov.mt.vigilancia.saude.service.GeracodigocertificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geracodigocertificacoes")
public class GeracodigocertificacaoController {

    @Autowired
    private GeracodigocertificacaoService geracodigocertificacaoService;

    @GetMapping
    public ResponseEntity<List<GeracodigocertificacaoDTO>> getAllGeracodigocertificacoes() {
        return ResponseEntity.ok(geracodigocertificacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeracodigocertificacaoDTO> getGeracodigocertificacaoById(@PathVariable Integer id) {
        return geracodigocertificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeracodigocertificacaoDTO> createGeracodigocertificacao(@RequestBody GeracodigocertificacaoDTO geracodigocertificacaoDTO) {
        return ResponseEntity.ok(geracodigocertificacaoService.save(geracodigocertificacaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeracodigocertificacaoDTO> updateGeracodigocertificacao(@PathVariable Integer id, @RequestBody GeracodigocertificacaoDTO geracodigocertificacaoDTO) {
        return geracodigocertificacaoService.findById(id)
                .map(existingGeracodigocertificacaoDTO -> {
                    geracodigocertificacaoDTO.setIdcodigocertificacao(id);
                    return ResponseEntity.ok(geracodigocertificacaoService.save(geracodigocertificacaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeracodigocertificacao(@PathVariable Integer id) {
        geracodigocertificacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
