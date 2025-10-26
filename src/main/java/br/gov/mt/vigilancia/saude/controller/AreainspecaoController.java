package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AreainspecaoDTO;
import br.gov.mt.vigilancia.saude.service.AreainspecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areainspecao")
public class AreainspecaoController {

    @Autowired
    private AreainspecaoService areainspecaoService;

    @GetMapping
    public ResponseEntity<List<AreainspecaoDTO>> getAllAreainspecao() {
        return ResponseEntity.ok(areainspecaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreainspecaoDTO> getAreainspecaoById(@PathVariable Integer id) {
        return areainspecaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AreainspecaoDTO> createAreainspecao(@RequestBody AreainspecaoDTO areainspecaoDTO) {
        return ResponseEntity.ok(areainspecaoService.save(areainspecaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreainspecaoDTO> updateAreainspecao(@PathVariable Integer id, @RequestBody AreainspecaoDTO areainspecaoDTO) {
        return areainspecaoService.findById(id)
                .map(existingAreainspecaoDTO -> {
                    areainspecaoDTO.setIdareainspecao(id);
                    return ResponseEntity.ok(areainspecaoService.save(areainspecaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAreainspecao(@PathVariable Integer id) {
        areainspecaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
