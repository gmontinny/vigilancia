package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TabelainfracoeDTO;
import br.gov.mt.vigilancia.saude.service.TabelainfracoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tabelainfracoes")
public class TabelainfracoeController {

    @Autowired
    private TabelainfracoeService tabelainfracoeService;

    @GetMapping
    public ResponseEntity<List<TabelainfracoeDTO>> getAllTabelainfracoes() {
        return ResponseEntity.ok(tabelainfracoeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TabelainfracoeDTO> getTabelainfracoeById(@PathVariable Integer id) {
        return tabelainfracoeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TabelainfracoeDTO> createTabelainfracoe(@RequestBody TabelainfracoeDTO tabelainfracoeDTO) {
        return ResponseEntity.ok(tabelainfracoeService.save(tabelainfracoeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TabelainfracoeDTO> updateTabelainfracoe(@PathVariable Integer id, @RequestBody TabelainfracoeDTO tabelainfracoeDTO) {
        return tabelainfracoeService.findById(id)
                .map(existingTabelainfracoeDTO -> {
                    tabelainfracoeDTO.setIdtabelainfracoes(id);
                    return ResponseEntity.ok(tabelainfracoeService.save(tabelainfracoeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabelainfracoe(@PathVariable Integer id) {
        tabelainfracoeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
