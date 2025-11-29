package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AnaliseprocessoDTO;
import br.gov.mt.vigilancia.saude.service.AnaliseprocessoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de análises de processo.
 */
@RestController
@RequestMapping("/analiseprocessos")
@Tag(name = "Análises de Processo", description = "Consulta de análises de processo")
@SecurityRequirement(name = "bearerAuth")
public class AnaliseprocessoController {

    @Autowired
    private AnaliseprocessoService analiseprocessoService;

    @GetMapping
    @Operation(summary = "Listar análises de processo", description = "Retorna todas as análises de processo cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AnaliseprocessoDTO>> getAllAnaliseprocessos() {
        return ResponseEntity.ok(analiseprocessoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnaliseprocessoDTO> getAnaliseprocessoById(@PathVariable Integer id) {
        return analiseprocessoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AnaliseprocessoDTO> createAnaliseprocesso(@RequestBody AnaliseprocessoDTO analiseprocessoDTO) {
        return ResponseEntity.ok(analiseprocessoService.save(analiseprocessoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnaliseprocessoDTO> updateAnaliseprocesso(@PathVariable Integer id, @RequestBody AnaliseprocessoDTO analiseprocessoDTO) {
        return analiseprocessoService.findById(id)
                .map(existingAnaliseprocessoDTO -> {
                    analiseprocessoDTO.setIdanaliseprocesso(id);
                    return ResponseEntity.ok(analiseprocessoService.save(analiseprocessoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnaliseprocesso(@PathVariable Integer id) {
        analiseprocessoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
