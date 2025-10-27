package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AtividadevigilanciaDTO;
import br.gov.mt.vigilancia.saude.service.AtividadevigilanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividadevigilancias")
public class AtividadevigilanciaController {

    @Autowired
    private AtividadevigilanciaService atividadevigilanciaService;

    @GetMapping
    public ResponseEntity<List<AtividadevigilanciaDTO>> getAllAtividadevigilancias() {
        return ResponseEntity.ok(atividadevigilanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadevigilanciaDTO> getAtividadevigilanciaById(@PathVariable Integer id) {
        return atividadevigilanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadevigilanciaDTO> createAtividadevigilancia(@RequestBody AtividadevigilanciaDTO atividadevigilanciaDTO) {
        return ResponseEntity.ok(atividadevigilanciaService.save(atividadevigilanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadevigilanciaDTO> updateAtividadevigilancia(@PathVariable Integer id, @RequestBody AtividadevigilanciaDTO atividadevigilanciaDTO) {
        return atividadevigilanciaService.findById(id)
                .map(existingAtividadevigilanciaDTO -> {
                    atividadevigilanciaDTO.setIdatividade(id);
                    return ResponseEntity.ok(atividadevigilanciaService.save(atividadevigilanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividadevigilancia(@PathVariable Integer id) {
        atividadevigilanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
