package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachoimprocedenciaDTO;
import br.gov.mt.vigilancia.saude.service.DespachoimprocedenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despachoimprocedencias")
public class DespachoimprocedenciaController {

    @Autowired
    private DespachoimprocedenciaService despachoimprocedenciaService;

    @GetMapping
    public ResponseEntity<List<DespachoimprocedenciaDTO>> getAllDespachoimprocedencias() {
        return ResponseEntity.ok(despachoimprocedenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespachoimprocedenciaDTO> getDespachoimprocedenciaById(@PathVariable Integer id) {
        return despachoimprocedenciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DespachoimprocedenciaDTO> createDespachoimprocedencia(@RequestBody DespachoimprocedenciaDTO despachoimprocedenciaDTO) {
        return ResponseEntity.ok(despachoimprocedenciaService.save(despachoimprocedenciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespachoimprocedenciaDTO> updateDespachoimprocedencia(@PathVariable Integer id, @RequestBody DespachoimprocedenciaDTO despachoimprocedenciaDTO) {
        return despachoimprocedenciaService.findById(id)
                .map(existingDespachoimprocedenciaDTO -> {
                    despachoimprocedenciaDTO.setIddespachoimprocedencia(id);
                    return ResponseEntity.ok(despachoimprocedenciaService.save(despachoimprocedenciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespachoimprocedencia(@PathVariable Integer id) {
        despachoimprocedenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
