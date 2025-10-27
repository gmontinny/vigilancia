package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AtividadefiscalDTO;
import br.gov.mt.vigilancia.saude.service.AtividadefiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividadefiscais")
public class AtividadefiscalController {

    @Autowired
    private AtividadefiscalService atividadefiscalService;

    @GetMapping
    public ResponseEntity<List<AtividadefiscalDTO>> getAllAtividadefiscais() {
        return ResponseEntity.ok(atividadefiscalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadefiscalDTO> getAtividadefiscalById(@PathVariable Integer id) {
        return atividadefiscalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadefiscalDTO> createAtividadefiscal(@RequestBody AtividadefiscalDTO atividadefiscalDTO) {
        return ResponseEntity.ok(atividadefiscalService.save(atividadefiscalDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadefiscalDTO> updateAtividadefiscal(@PathVariable Integer id, @RequestBody AtividadefiscalDTO atividadefiscalDTO) {
        return atividadefiscalService.findById(id)
                .map(existingAtividadefiscalDTO -> {
                    atividadefiscalDTO.setIdatividadefiscal(id);
                    return ResponseEntity.ok(atividadefiscalService.save(atividadefiscalDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividadefiscal(@PathVariable Integer id) {
        atividadefiscalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
