package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResultadosegundainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.ResultadosegundainstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultadosegundainstancias")
public class ResultadosegundainstanciaController {

    @Autowired
    private ResultadosegundainstanciaService resultadosegundainstanciaService;

    @GetMapping
    public ResponseEntity<List<ResultadosegundainstanciaDTO>> getAllResultadosegundainstancias() {
        return ResponseEntity.ok(resultadosegundainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadosegundainstanciaDTO> getResultadosegundainstanciaById(@PathVariable Integer id) {
        return resultadosegundainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResultadosegundainstanciaDTO> createResultadosegundainstancia(@RequestBody ResultadosegundainstanciaDTO resultadosegundainstanciaDTO) {
        return ResponseEntity.ok(resultadosegundainstanciaService.save(resultadosegundainstanciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadosegundainstanciaDTO> updateResultadosegundainstancia(@PathVariable Integer id, @RequestBody ResultadosegundainstanciaDTO resultadosegundainstanciaDTO) {
        return resultadosegundainstanciaService.findById(id)
                .map(existingResultadosegundainstanciaDTO -> {
                    resultadosegundainstanciaDTO.setIdresultadosegunda(id);
                    return ResponseEntity.ok(resultadosegundainstanciaService.save(resultadosegundainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultadosegundainstancia(@PathVariable Integer id) {
        resultadosegundainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
