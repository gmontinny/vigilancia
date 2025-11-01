package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UploadnecessarioDTO;
import br.gov.mt.vigilancia.saude.service.UploadnecessarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uploadnecessarios")
public class UploadnecessarioController {

    @Autowired
    private UploadnecessarioService uploadnecessarioService;

    @GetMapping
    public ResponseEntity<List<UploadnecessarioDTO>> getAllUploadnecessarios() {
        return ResponseEntity.ok(uploadnecessarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UploadnecessarioDTO> getUploadnecessarioById(@PathVariable Integer id) {
        return uploadnecessarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UploadnecessarioDTO> createUploadnecessario(@RequestBody UploadnecessarioDTO uploadnecessarioDTO) {
        return ResponseEntity.ok(uploadnecessarioService.save(uploadnecessarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UploadnecessarioDTO> updateUploadnecessario(@PathVariable Integer id, @RequestBody UploadnecessarioDTO uploadnecessarioDTO) {
        return uploadnecessarioService.findById(id)
                .map(existingUploadnecessarioDTO -> {
                    uploadnecessarioDTO.setIduploadnecessario(id);
                    return ResponseEntity.ok(uploadnecessarioService.save(uploadnecessarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUploadnecessario(@PathVariable Integer id) {
        uploadnecessarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
