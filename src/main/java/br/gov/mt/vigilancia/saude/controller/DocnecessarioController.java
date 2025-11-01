package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DocnecessarioDTO;
import br.gov.mt.vigilancia.saude.service.DocnecessarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docnecessarios")
public class DocnecessarioController {

    @Autowired
    private DocnecessarioService docnecessarioService;

    @GetMapping
    public ResponseEntity<List<DocnecessarioDTO>> getAllDocnecessarios() {
        return ResponseEntity.ok(docnecessarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocnecessarioDTO> getDocnecessarioById(@PathVariable Integer id) {
        return docnecessarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DocnecessarioDTO> createDocnecessario(@RequestBody DocnecessarioDTO docnecessarioDTO) {
        return ResponseEntity.ok(docnecessarioService.save(docnecessarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocnecessarioDTO> updateDocnecessario(@PathVariable Integer id, @RequestBody DocnecessarioDTO docnecessarioDTO) {
        return docnecessarioService.findById(id)
                .map(existingDocnecessarioDTO -> {
                    docnecessarioDTO.setIddocnecessario(id);
                    return ResponseEntity.ok(docnecessarioService.save(docnecessarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocnecessario(@PathVariable Integer id) {
        docnecessarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
