package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachoreveliaDTO;
import br.gov.mt.vigilancia.saude.service.DespachoreveliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despachorevelias")
public class DespachoreveliaController {

    @Autowired
    private DespachoreveliaService despachoreveliaService;

    @GetMapping
    public ResponseEntity<List<DespachoreveliaDTO>> getAllDespachorevelias() {
        return ResponseEntity.ok(despachoreveliaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespachoreveliaDTO> getDespachoreveliaById(@PathVariable Integer id) {
        return despachoreveliaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DespachoreveliaDTO> createDespachorevelia(@RequestBody DespachoreveliaDTO despachoreveliaDTO) {
        return ResponseEntity.ok(despachoreveliaService.save(despachoreveliaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespachoreveliaDTO> updateDespachorevelia(@PathVariable Integer id, @RequestBody DespachoreveliaDTO despachoreveliaDTO) {
        return despachoreveliaService.findById(id)
                .map(existingDespachoreveliaDTO -> {
                    despachoreveliaDTO.setIddespachorevelia(id);
                    return ResponseEntity.ok(despachoreveliaService.save(despachoreveliaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespachorevelia(@PathVariable Integer id) {
        despachoreveliaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
