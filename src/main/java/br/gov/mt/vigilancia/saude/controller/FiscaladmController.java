package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.FiscaladmDTO;
import br.gov.mt.vigilancia.saude.service.FiscaladmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiscaladms")
public class FiscaladmController {

    @Autowired
    private FiscaladmService fiscaladmService;

    @GetMapping
    public List<FiscaladmDTO> getAllFiscaladms() {
        return fiscaladmService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiscaladmDTO> getFiscaladmById(@PathVariable Integer id) {
        return fiscaladmService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FiscaladmDTO createFiscaladm(@RequestBody FiscaladmDTO fiscaladmDTO) {
        return fiscaladmService.save(fiscaladmDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiscaladmDTO> updateFiscaladm(@PathVariable Integer id, @RequestBody FiscaladmDTO fiscaladmDTO) {
        return fiscaladmService.findById(id)
                .map(existingFiscaladm -> {
                    fiscaladmDTO.setIdFiscaladm(id);
                    return ResponseEntity.ok(fiscaladmService.save(fiscaladmDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiscaladm(@PathVariable Integer id) {
        if (fiscaladmService.findById(id).isPresent()) {
            fiscaladmService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
