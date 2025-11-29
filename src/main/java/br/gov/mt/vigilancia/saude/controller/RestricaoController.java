package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RestricaoDTO;
import br.gov.mt.vigilancia.saude.service.RestricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restricoes")
public class RestricaoController {

    @Autowired
    private RestricaoService restricaoService;

    @GetMapping
    public ResponseEntity<List<RestricaoDTO>> getAllRestricoes() {
        return ResponseEntity.ok(restricaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestricaoDTO> getRestricaoById(@PathVariable Integer id) {
        return restricaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RestricaoDTO> createRestricao(@RequestBody RestricaoDTO restricaoDTO) {
        return ResponseEntity.ok(restricaoService.save(restricaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestricaoDTO> updateRestricao(@PathVariable Integer id, @RequestBody RestricaoDTO restricaoDTO) {
        return restricaoService.findById(id)
                .map(existingRestricaoDTO -> {
                    restricaoDTO.setIdrestricao(id);
                    return ResponseEntity.ok(restricaoService.save(restricaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestricao(@PathVariable Integer id) {
        restricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
