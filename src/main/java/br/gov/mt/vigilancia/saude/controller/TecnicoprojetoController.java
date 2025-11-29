package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TecnicoprojetoDTO;
import br.gov.mt.vigilancia.saude.service.TecnicoprojetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicoprojetos")
public class TecnicoprojetoController {

    @Autowired
    private TecnicoprojetoService tecnicoprojetoService;

    @GetMapping
    public ResponseEntity<List<TecnicoprojetoDTO>> getAllTecnicoprojetos() {
        return ResponseEntity.ok(tecnicoprojetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoprojetoDTO> getTecnicoprojetoById(@PathVariable Integer id) {
        return tecnicoprojetoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TecnicoprojetoDTO> createTecnicoprojeto(@RequestBody TecnicoprojetoDTO tecnicoprojetoDTO) {
        return ResponseEntity.ok(tecnicoprojetoService.save(tecnicoprojetoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoprojetoDTO> updateTecnicoprojeto(@PathVariable Integer id, @RequestBody TecnicoprojetoDTO tecnicoprojetoDTO) {
        return tecnicoprojetoService.findById(id)
                .map(existingTecnicoprojetoDTO -> {
                    tecnicoprojetoDTO.setIdtecnicoprojeto(id);
                    return ResponseEntity.ok(tecnicoprojetoService.save(tecnicoprojetoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTecnicoprojeto(@PathVariable Integer id) {
        tecnicoprojetoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
