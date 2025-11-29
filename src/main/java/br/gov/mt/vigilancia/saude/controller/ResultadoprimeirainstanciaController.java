package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResultadoprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.ResultadoprimeirainstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultadoprimeirainstancias")
public class ResultadoprimeirainstanciaController {

    @Autowired
    private ResultadoprimeirainstanciaService resultadoprimeirainstanciaService;

    @GetMapping
    public ResponseEntity<List<ResultadoprimeirainstanciaDTO>> getAllResultadoprimeirainstancias() {
        return ResponseEntity.ok(resultadoprimeirainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoprimeirainstanciaDTO> getResultadoprimeirainstanciaById(@PathVariable Integer id) {
        return resultadoprimeirainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResultadoprimeirainstanciaDTO> createResultadoprimeirainstancia(@RequestBody ResultadoprimeirainstanciaDTO resultadoprimeirainstanciaDTO) {
        return ResponseEntity.ok(resultadoprimeirainstanciaService.save(resultadoprimeirainstanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoprimeirainstanciaDTO> updateResultadoprimeirainstancia(@PathVariable Integer id, @RequestBody ResultadoprimeirainstanciaDTO resultadoprimeirainstanciaDTO) {
        return resultadoprimeirainstanciaService.findById(id)
                .map(existingResultadoprimeirainstanciaDTO -> {
                    resultadoprimeirainstanciaDTO.setIdresultadoprimeira(id);
                    return ResponseEntity.ok(resultadoprimeirainstanciaService.save(resultadoprimeirainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultadoprimeirainstancia(@PathVariable Integer id) {
        resultadoprimeirainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
