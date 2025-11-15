package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotrecursoadmprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.NotrecursoadmprimeirainstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notrecursoadmprimeirainstancias")
public class NotrecursoadmprimeirainstanciaController {

    @Autowired
    private NotrecursoadmprimeirainstanciaService notrecursoadmprimeirainstanciaService;

    @GetMapping
    public ResponseEntity<List<NotrecursoadmprimeirainstanciaDTO>> getAllNotrecursoadmprimeirainstancias() {
        return ResponseEntity.ok(notrecursoadmprimeirainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotrecursoadmprimeirainstanciaDTO> getNotrecursoadmprimeirainstanciaById(@PathVariable Integer id) {
        return notrecursoadmprimeirainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotrecursoadmprimeirainstanciaDTO> createNotrecursoadmprimeirainstancia(@RequestBody NotrecursoadmprimeirainstanciaDTO notrecursoadmprimeirainstanciaDTO) {
        return ResponseEntity.ok(notrecursoadmprimeirainstanciaService.save(notrecursoadmprimeirainstanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotrecursoadmprimeirainstanciaDTO> updateNotrecursoadmprimeirainstancia(@PathVariable Integer id, @RequestBody NotrecursoadmprimeirainstanciaDTO notrecursoadmprimeirainstanciaDTO) {
        return notrecursoadmprimeirainstanciaService.findById(id)
                .map(existingNotrecursoadmprimeirainstanciaDTO -> {
                    notrecursoadmprimeirainstanciaDTO.setIdnotrecursoadmprimeirainstancia(id);
                    return ResponseEntity.ok(notrecursoadmprimeirainstanciaService.save(notrecursoadmprimeirainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotrecursoadmprimeirainstancia(@PathVariable Integer id) {
        notrecursoadmprimeirainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
