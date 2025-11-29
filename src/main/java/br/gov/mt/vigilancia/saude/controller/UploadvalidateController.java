package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UploadvalidateDTO;
import br.gov.mt.vigilancia.saude.service.UploadvalidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uploadvalidates")
public class UploadvalidateController {

    @Autowired
    private UploadvalidateService uploadvalidateService;

    @GetMapping
    public ResponseEntity<List<UploadvalidateDTO>> getAllUploadvalidates() {
        return ResponseEntity.ok(uploadvalidateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UploadvalidateDTO> getUploadvalidateById(@PathVariable Integer id) {
        return uploadvalidateService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UploadvalidateDTO> createUploadvalidate(@RequestBody UploadvalidateDTO uploadvalidateDTO) {
        return ResponseEntity.ok(uploadvalidateService.save(uploadvalidateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UploadvalidateDTO> updateUploadvalidate(@PathVariable Integer id, @RequestBody UploadvalidateDTO uploadvalidateDTO) {
        return uploadvalidateService.findById(id)
                .map(existingUploadvalidateDTO -> {
                    uploadvalidateDTO.setIduploadvalidate(id);
                    return ResponseEntity.ok(uploadvalidateService.save(uploadvalidateDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUploadvalidate(@PathVariable Integer id) {
        uploadvalidateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
