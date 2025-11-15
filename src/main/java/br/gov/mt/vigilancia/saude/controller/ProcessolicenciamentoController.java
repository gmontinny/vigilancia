package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessolicenciamentoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessolicenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processolicenciamentos")
public class ProcessolicenciamentoController {

    @Autowired
    private ProcessolicenciamentoService processolicenciamentoService;

    @GetMapping
    public ResponseEntity<List<ProcessolicenciamentoDTO>> getAllProcessolicenciamentos() {
        return ResponseEntity.ok(processolicenciamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessolicenciamentoDTO> getProcessolicenciamentoById(@PathVariable Integer id) {
        return processolicenciamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProcessolicenciamentoDTO> createProcessolicenciamento(@RequestBody ProcessolicenciamentoDTO processolicenciamentoDTO) {
        return ResponseEntity.ok(processolicenciamentoService.save(processolicenciamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessolicenciamentoDTO> updateProcessolicenciamento(@PathVariable Integer id, @RequestBody ProcessolicenciamentoDTO processolicenciamentoDTO) {
        return processolicenciamentoService.findById(id)
                .map(existingProcessolicenciamentoDTO -> {
                    processolicenciamentoDTO.setIdprocessolicenciamento(id);
                    return ResponseEntity.ok(processolicenciamentoService.save(processolicenciamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessolicenciamento(@PathVariable Integer id) {
        processolicenciamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
