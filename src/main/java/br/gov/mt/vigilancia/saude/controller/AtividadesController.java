package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AtividadesDTO;
import br.gov.mt.vigilancia.saude.service.AtividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadesController {

    @Autowired
    private AtividadesService atividadesService;

    @GetMapping
    public ResponseEntity<List<AtividadesDTO>> getAllAtividades() {
        return ResponseEntity.ok(atividadesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadesDTO> getAtividadesById(@PathVariable Integer id) {
        return atividadesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadesDTO> createAtividades(@RequestBody AtividadesDTO atividadesDTO) {
        return ResponseEntity.ok(atividadesService.save(atividadesDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadesDTO> updateAtividades(@PathVariable Integer id, @RequestBody AtividadesDTO atividadesDTO) {
        return atividadesService.findById(id)
                .map(existingAtividadesDTO -> {
                    atividadesDTO.setIdatividades(id);
                    return ResponseEntity.ok(atividadesService.save(atividadesDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividades(@PathVariable Integer id) {
        atividadesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
