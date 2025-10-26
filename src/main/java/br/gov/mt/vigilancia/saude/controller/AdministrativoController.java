package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AdministrativoDTO;
import br.gov.mt.vigilancia.saude.service.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrativos")
public class AdministrativoController {

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping
    public ResponseEntity<List<AdministrativoDTO>> getAllAdministrativos() {
        return ResponseEntity.ok(administrativoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministrativoDTO> getAdministrativoById(@PathVariable Integer id) {
        return administrativoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdministrativoDTO> createAdministrativo(@RequestBody AdministrativoDTO administrativoDTO) {
        return ResponseEntity.ok(administrativoService.save(administrativoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministrativoDTO> updateAdministrativo(@PathVariable Integer id, @RequestBody AdministrativoDTO administrativoDTO) {
        return administrativoService.findById(id)
                .map(existingAdministrativoDTO -> {
                    administrativoDTO.setIdadministrativo(id);
                    return ResponseEntity.ok(administrativoService.save(administrativoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrativo(@PathVariable Integer id) {
        administrativoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
