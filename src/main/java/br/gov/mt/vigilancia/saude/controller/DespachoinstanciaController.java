package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachoinstanciaDTO;
import br.gov.mt.vigilancia.saude.service.DespachoinstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despachoinstancias")
public class DespachoinstanciaController {

    @Autowired
    private DespachoinstanciaService despachoinstanciaService;

    @GetMapping
    public ResponseEntity<List<DespachoinstanciaDTO>> getAllDespachoinstancias() {
        return ResponseEntity.ok(despachoinstanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespachoinstanciaDTO> getDespachoinstanciaById(@PathVariable Integer id) {
        return despachoinstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DespachoinstanciaDTO> createDespachoinstancia(@RequestBody DespachoinstanciaDTO despachoinstanciaDTO) {
        return ResponseEntity.ok(despachoinstanciaService.save(despachoinstanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespachoinstanciaDTO> updateDespachoinstancia(@PathVariable Integer id, @RequestBody DespachoinstanciaDTO despachoinstanciaDTO) {
        return despachoinstanciaService.findById(id)
                .map(existingDespachoinstanciaDTO -> {
                    despachoinstanciaDTO.setIddespachoinstancia(id);
                    return ResponseEntity.ok(despachoinstanciaService.save(despachoinstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespachoinstancia(@PathVariable Integer id) {
        despachoinstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
