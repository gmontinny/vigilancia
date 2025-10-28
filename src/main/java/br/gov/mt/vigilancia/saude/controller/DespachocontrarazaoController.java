package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachocontrarazaoDTO;
import br.gov.mt.vigilancia.saude.service.DespachocontrarazaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despachocontrarazoes")
public class DespachocontrarazaoController {

    @Autowired
    private DespachocontrarazaoService despachocontrarazaoService;

    @GetMapping
    public ResponseEntity<List<DespachocontrarazaoDTO>> getAllDespachocontrarazoes() {
        return ResponseEntity.ok(despachocontrarazaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespachocontrarazaoDTO> getDespachocontrarazaoById(@PathVariable Integer id) {
        return despachocontrarazaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DespachocontrarazaoDTO> createDespachocontrarazao(@RequestBody DespachocontrarazaoDTO despachocontrarazaoDTO) {
        return ResponseEntity.ok(despachocontrarazaoService.save(despachocontrarazaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespachocontrarazaoDTO> updateDespachocontrarazao(@PathVariable Integer id, @RequestBody DespachocontrarazaoDTO despachocontrarazaoDTO) {
        return despachocontrarazaoService.findById(id)
                .map(existingDespachocontrarazaoDTO -> {
                    despachocontrarazaoDTO.setIddespachocontrarazao(id);
                    return ResponseEntity.ok(despachocontrarazaoService.save(despachocontrarazaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespachocontrarazao(@PathVariable Integer id) {
        despachocontrarazaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
