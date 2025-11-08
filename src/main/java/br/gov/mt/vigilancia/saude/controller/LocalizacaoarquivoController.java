package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LocalizacaoarquivoDTO;
import br.gov.mt.vigilancia.saude.service.LocalizacaoarquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacaoarquivos")
public class LocalizacaoarquivoController {

    @Autowired
    private LocalizacaoarquivoService localizacaoarquivoService;

    @GetMapping
    public ResponseEntity<List<LocalizacaoarquivoDTO>> getAllLocalizacaoarquivos() {
        return ResponseEntity.ok(localizacaoarquivoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoarquivoDTO> getLocalizacaoarquivoById(@PathVariable Integer id) {
        return localizacaoarquivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocalizacaoarquivoDTO> createLocalizacaoarquivo(@RequestBody LocalizacaoarquivoDTO localizacaoarquivoDTO) {
        return ResponseEntity.ok(localizacaoarquivoService.save(localizacaoarquivoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalizacaoarquivoDTO> updateLocalizacaoarquivo(@PathVariable Integer id, @RequestBody LocalizacaoarquivoDTO localizacaoarquivoDTO) {
        return localizacaoarquivoService.findById(id)
                .map(existingLocalizacaoarquivoDTO -> {
                    localizacaoarquivoDTO.setIdlocalizacaoarquivo(id);
                    return ResponseEntity.ok(localizacaoarquivoService.save(localizacaoarquivoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalizacaoarquivo(@PathVariable Integer id) {
        localizacaoarquivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
