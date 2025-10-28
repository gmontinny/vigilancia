package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TipoinspecaoDTO;
import br.gov.mt.vigilancia.saude.service.TipoinspecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposinspecao")
public class TipoinspecaoController {

    @Autowired
    private TipoinspecaoService tipoinspecaoService;

    @GetMapping
    public ResponseEntity<List<TipoinspecaoDTO>> getAllTipoinspecoes() {
        return ResponseEntity.ok(tipoinspecaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoinspecaoDTO> getTipoinspecaoById(@PathVariable Integer id) {
        return tipoinspecaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoinspecaoDTO> createTipoinspecao(@RequestBody TipoinspecaoDTO tipoinspecaoDTO) {
        return ResponseEntity.ok(tipoinspecaoService.save(tipoinspecaoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoinspecaoDTO> updateTipoinspecao(@PathVariable Integer id, @RequestBody TipoinspecaoDTO tipoinspecaoDTO) {
        return tipoinspecaoService.findById(id)
                .map(existingTipoinspecaoDTO -> {
                    tipoinspecaoDTO.setIdtipoinspecao(id);
                    return ResponseEntity.ok(tipoinspecaoService.save(tipoinspecaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoinspecao(@PathVariable Integer id) {
        tipoinspecaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
