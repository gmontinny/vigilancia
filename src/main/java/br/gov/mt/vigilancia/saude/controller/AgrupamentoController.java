package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AgrupamentoDTO;
import br.gov.mt.vigilancia.saude.service.AgrupamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agrupamentos")
public class AgrupamentoController {

    @Autowired
    private AgrupamentoService agrupamentoService;

    @GetMapping
    public ResponseEntity<List<AgrupamentoDTO>> getAllAgrupamentos() {
        return ResponseEntity.ok(agrupamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgrupamentoDTO> getAgrupamentoById(@PathVariable Integer id) {
        return agrupamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgrupamentoDTO> createAgrupamento(@RequestBody AgrupamentoDTO agrupamentoDTO) {
        return ResponseEntity.ok(agrupamentoService.save(agrupamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgrupamentoDTO> updateAgrupamento(@PathVariable Integer id, @RequestBody AgrupamentoDTO agrupamentoDTO) {
        return agrupamentoService.findById(id)
                .map(existingAgrupamentoDTO -> {
                    agrupamentoDTO.setIdagrupamento(id);
                    return ResponseEntity.ok(agrupamentoService.save(agrupamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgrupamento(@PathVariable Integer id) {
        agrupamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
