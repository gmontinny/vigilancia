package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ValorautoDTO;
import br.gov.mt.vigilancia.saude.service.ValorautoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valorautos")
public class ValorautoController {

    @Autowired
    private ValorautoService valorautoService;

    @GetMapping
    public ResponseEntity<List<ValorautoDTO>> getAllValorautos() {
        return ResponseEntity.ok(valorautoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValorautoDTO> getValorautoById(@PathVariable Integer id) {
        return valorautoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ValorautoDTO> createValorauto(@RequestBody ValorautoDTO valorautoDTO) {
        return ResponseEntity.ok(valorautoService.save(valorautoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValorautoDTO> updateValorauto(@PathVariable Integer id, @RequestBody ValorautoDTO valorautoDTO) {
        return valorautoService.findById(id)
                .map(existingValorautoDTO -> {
                    valorautoDTO.setIdvalorauto(id);
                    return ResponseEntity.ok(valorautoService.save(valorautoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValorauto(@PathVariable Integer id) {
        valorautoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
