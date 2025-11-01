package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EmpresainfracoeDTO;
import br.gov.mt.vigilancia.saude.service.EmpresainfracoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresainfracoes")
public class EmpresainfracoeController {

    @Autowired
    private EmpresainfracoeService empresainfracoeService;

    @GetMapping
    public ResponseEntity<List<EmpresainfracoeDTO>> getAllEmpresainfracoes() {
        return ResponseEntity.ok(empresainfracoeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresainfracoeDTO> getEmpresainfracoeById(@PathVariable Integer id) {
        return empresainfracoeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpresainfracoeDTO> createEmpresainfracoe(@RequestBody EmpresainfracoeDTO empresainfracoeDTO) {
        return ResponseEntity.ok(empresainfracoeService.save(empresainfracoeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresainfracoeDTO> updateEmpresainfracoe(@PathVariable Integer id, @RequestBody EmpresainfracoeDTO empresainfracoeDTO) {
        return empresainfracoeService.findById(id)
                .map(existingEmpresainfracoeDTO -> {
                    empresainfracoeDTO.setIdempresainfracoes(id);
                    return ResponseEntity.ok(empresainfracoeService.save(empresainfracoeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresainfracoe(@PathVariable Integer id) {
        empresainfracoeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
