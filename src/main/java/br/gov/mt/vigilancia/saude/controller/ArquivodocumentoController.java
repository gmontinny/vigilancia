package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ArquivodocumentoDTO;
import br.gov.mt.vigilancia.saude.service.ArquivodocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arquivodocumentos")
public class ArquivodocumentoController {

    @Autowired
    private ArquivodocumentoService arquivodocumentoService;

    @GetMapping
    public ResponseEntity<List<ArquivodocumentoDTO>> getAllArquivodocumentos() {
        return ResponseEntity.ok(arquivodocumentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArquivodocumentoDTO> getArquivodocumentoById(@PathVariable Integer id) {
        return arquivodocumentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArquivodocumentoDTO> createArquivodocumento(@RequestBody ArquivodocumentoDTO arquivodocumentoDTO) {
        return ResponseEntity.ok(arquivodocumentoService.save(arquivodocumentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArquivodocumentoDTO> updateArquivodocumento(@PathVariable Integer id, @RequestBody ArquivodocumentoDTO arquivodocumentoDTO) {
        return arquivodocumentoService.findById(id)
                .map(existingArquivodocumentoDTO -> {
                    arquivodocumentoDTO.setIdarquivo(id);
                    return ResponseEntity.ok(arquivodocumentoService.save(arquivodocumentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArquivodocumento(@PathVariable Integer id) {
        arquivodocumentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
