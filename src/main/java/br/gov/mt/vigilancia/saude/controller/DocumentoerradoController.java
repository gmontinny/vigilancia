package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DocumentoerradoDTO;
import br.gov.mt.vigilancia.saude.service.DocumentoerradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentoserrados")
public class DocumentoerradoController {

    @Autowired
    private DocumentoerradoService documentoerradoService;

    @GetMapping
    public ResponseEntity<List<DocumentoerradoDTO>> getAllDocumentoserrados() {
        return ResponseEntity.ok(documentoerradoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoerradoDTO> getDocumentoerradoById(@PathVariable Integer id) {
        return documentoerradoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DocumentoerradoDTO> createDocumentoerrado(@RequestBody DocumentoerradoDTO documentoerradoDTO) {
        return ResponseEntity.ok(documentoerradoService.save(documentoerradoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoerradoDTO> updateDocumentoerrado(@PathVariable Integer id, @RequestBody DocumentoerradoDTO documentoerradoDTO) {
        return documentoerradoService.findById(id)
                .map(existingDocumentoerradoDTO -> {
                    documentoerradoDTO.setIddocumentoerrado(id);
                    return ResponseEntity.ok(documentoerradoService.save(documentoerradoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentoerrado(@PathVariable Integer id) {
        documentoerradoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
