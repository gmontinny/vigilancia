package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItensdocumentoDTO;
import br.gov.mt.vigilancia.saude.service.ItensdocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensdocumentos")
public class ItensdocumentoController {

    @Autowired
    private ItensdocumentoService itensdocumentoService;

    @GetMapping
    public ResponseEntity<List<ItensdocumentoDTO>> getAllItensdocumentos() {
        return ResponseEntity.ok(itensdocumentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensdocumentoDTO> getItensdocumentoById(@PathVariable Integer id) {
        return itensdocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItensdocumentoDTO> createItensdocumento(@RequestBody ItensdocumentoDTO itensdocumentoDTO) {
        return ResponseEntity.ok(itensdocumentoService.save(itensdocumentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensdocumentoDTO> updateItensdocumento(@PathVariable Integer id, @RequestBody ItensdocumentoDTO itensdocumentoDTO) {
        return itensdocumentoService.findById(id)
                .map(existingItensdocumentoDTO -> {
                    itensdocumentoDTO.setIditensdocumento(id);
                    return ResponseEntity.ok(itensdocumentoService.save(itensdocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItensdocumento(@PathVariable Integer id) {
        itensdocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
