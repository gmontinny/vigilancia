package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ProcessoadministrativoDTO;
import br.gov.mt.vigilancia.saude.service.ProcessoadministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processoadministrativos")
public class ProcessoadministrativoController {

    @Autowired
    private ProcessoadministrativoService processoadministrativoService;

    @GetMapping
    public ResponseEntity<List<ProcessoadministrativoDTO>> getAllProcessoadministrativos() {
        return ResponseEntity.ok(processoadministrativoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessoadministrativoDTO> getProcessoadministrativoById(@PathVariable Integer id) {
        return processoadministrativoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProcessoadministrativoDTO> createProcessoadministrativo(@RequestBody ProcessoadministrativoDTO processoadministrativoDTO) {
        return ResponseEntity.ok(processoadministrativoService.save(processoadministrativoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessoadministrativoDTO> updateProcessoadministrativo(@PathVariable Integer id, @RequestBody ProcessoadministrativoDTO processoadministrativoDTO) {
        return processoadministrativoService.findById(id)
                .map(existingProcessoadministrativoDTO -> {
                    processoadministrativoDTO.setIdprocessoadministrativo(id);
                    return ResponseEntity.ok(processoadministrativoService.save(processoadministrativoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessoadministrativo(@PathVariable Integer id) {
        processoadministrativoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
