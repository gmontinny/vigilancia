package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UploadrestricaoDTO;
import br.gov.mt.vigilancia.saude.service.UploadrestricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uploadrestricoes")
public class UploadrestricaoController {

    @Autowired
    private UploadrestricaoService uploadrestricaoService;

    @GetMapping
    public ResponseEntity<List<UploadrestricaoDTO>> getAllUploadrestricoes() {
        return ResponseEntity.ok(uploadrestricaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UploadrestricaoDTO> getUploadrestricaoById(@PathVariable Integer id) {
        return uploadrestricaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UploadrestricaoDTO> createUploadrestricao(@RequestBody UploadrestricaoDTO uploadrestricaoDTO) {
        return ResponseEntity.ok(uploadrestricaoService.save(uploadrestricaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UploadrestricaoDTO> updateUploadrestricao(@PathVariable Integer id, @RequestBody UploadrestricaoDTO uploadrestricaoDTO) {
        return uploadrestricaoService.findById(id)
                .map(existingUploadrestricaoDTO -> {
                    uploadrestricaoDTO.setIduploadrestricao(id);
                    return ResponseEntity.ok(uploadrestricaoService.save(uploadrestricaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUploadrestricao(@PathVariable Integer id) {
        uploadrestricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
