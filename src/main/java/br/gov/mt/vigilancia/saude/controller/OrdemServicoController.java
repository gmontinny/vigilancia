package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.OrdemServicoDTO;
import br.gov.mt.vigilancia.saude.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemservicos")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemservicoService;

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> getAllOrdemservicos() {
        return ResponseEntity.ok(ordemservicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoDTO> getOrdemservicoById(@PathVariable Integer id) {
        return ordemservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> createOrdemservico(@RequestBody OrdemServicoDTO ordemservicoDTO) {
        return ResponseEntity.ok(ordemservicoService.save(ordemservicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoDTO> updateOrdemservico(@PathVariable Integer id, @RequestBody OrdemServicoDTO ordemservicoDTO) {
        return ordemservicoService.findById(id)
                .map(existingOrdemservicoDTO -> {
                    ordemservicoDTO.setIdordemservico(id);
                    return ResponseEntity.ok(ordemservicoService.save(ordemservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdemservico(@PathVariable Integer id) {
        ordemservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
