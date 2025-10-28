package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BalancomedicamentoDTO;
import br.gov.mt.vigilancia.saude.service.BalancomedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balancomedicamentos")
public class BalancomedicamentoController {

    @Autowired
    private BalancomedicamentoService balancomedicamentoService;

    @GetMapping
    public ResponseEntity<List<BalancomedicamentoDTO>> getAllBalancomedicamentos() {
        return ResponseEntity.ok(balancomedicamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalancomedicamentoDTO> getBalancomedicamentoById(@PathVariable Integer id) {
        return balancomedicamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BalancomedicamentoDTO> createBalancomedicamento(@RequestBody BalancomedicamentoDTO balancomedicamentoDTO) {
        return ResponseEntity.ok(balancomedicamentoService.save(balancomedicamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BalancomedicamentoDTO> updateBalancomedicamento(@PathVariable Integer id, @RequestBody BalancomedicamentoDTO balancomedicamentoDTO) {
        return balancomedicamentoService.findById(id)
                .map(existingBalancomedicamentoDTO -> {
                    balancomedicamentoDTO.setIdbalanco(id);
                    return ResponseEntity.ok(balancomedicamentoService.save(balancomedicamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBalancomedicamento(@PathVariable Integer id) {
        balancomedicamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
