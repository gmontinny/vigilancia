package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItenscategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.service.ItenscategoriaservicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itenscategoriaservicos")
public class ItenscategoriaservicoController {

    @Autowired
    private ItenscategoriaservicoService itenscategoriaservicoService;

    @GetMapping
    public ResponseEntity<List<ItenscategoriaservicoDTO>> getAllItenscategoriaservicos() {
        return ResponseEntity.ok(itenscategoriaservicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItenscategoriaservicoDTO> getItenscategoriaservicoById(@PathVariable Integer id) {
        return itenscategoriaservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItenscategoriaservicoDTO> createItenscategoriaservico(@RequestBody ItenscategoriaservicoDTO itenscategoriaservicoDTO) {
        return ResponseEntity.ok(itenscategoriaservicoService.save(itenscategoriaservicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItenscategoriaservicoDTO> updateItenscategoriaservico(@PathVariable Integer id, @RequestBody ItenscategoriaservicoDTO itenscategoriaservicoDTO) {
        return itenscategoriaservicoService.findById(id)
                .map(existingItenscategoriaservicoDTO -> {
                    itenscategoriaservicoDTO.setIditenscategoriaservico(id);
                    return ResponseEntity.ok(itenscategoriaservicoService.save(itenscategoriaservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItenscategoriaservico(@PathVariable Integer id) {
        itenscategoriaservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
