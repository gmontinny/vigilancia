package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LicenciamentoDTO;
import br.gov.mt.vigilancia.saude.service.LicenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenciamentos")
public class LicenciamentoController {

    @Autowired
    private LicenciamentoService licenciamentoService;

    @GetMapping
    public ResponseEntity<List<LicenciamentoDTO>> getAllLicenciamentos() {
        return ResponseEntity.ok(licenciamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicenciamentoDTO> getLicenciamentoById(@PathVariable Integer id) {
        return licenciamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LicenciamentoDTO> createLicenciamento(@RequestBody LicenciamentoDTO licenciamentoDTO) {
        return ResponseEntity.ok(licenciamentoService.save(licenciamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LicenciamentoDTO> updateLicenciamento(@PathVariable Integer id, @RequestBody LicenciamentoDTO licenciamentoDTO) {
        return licenciamentoService.findById(id)
                .map(existingLicenciamentoDTO -> {
                    licenciamentoDTO.setIdlicenciamento(id);
                    return ResponseEntity.ok(licenciamentoService.save(licenciamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicenciamento(@PathVariable Integer id) {
        licenciamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
