package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TramiteadmDTO;
import br.gov.mt.vigilancia.saude.service.TramiteadmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tramiteadms")
public class TramiteadmController {

    @Autowired
    private TramiteadmService tramiteadmService;

    @GetMapping
    public ResponseEntity<List<TramiteadmDTO>> getAllTramiteadms() {
        return ResponseEntity.ok(tramiteadmService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramiteadmDTO> getTramiteadmById(@PathVariable Integer id) {
        return tramiteadmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TramiteadmDTO> createTramiteadm(@RequestBody TramiteadmDTO tramiteadmDTO) {
        return ResponseEntity.ok(tramiteadmService.save(tramiteadmDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TramiteadmDTO> updateTramiteadm(@PathVariable Integer id, @RequestBody TramiteadmDTO tramiteadmDTO) {
        return tramiteadmService.findById(id)
                .map(existingTramiteadmDTO -> {
                    tramiteadmDTO.setIdtramiteadm(id);
                    return ResponseEntity.ok(tramiteadmService.save(tramiteadmDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTramiteadm(@PathVariable Integer id) {
        tramiteadmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
