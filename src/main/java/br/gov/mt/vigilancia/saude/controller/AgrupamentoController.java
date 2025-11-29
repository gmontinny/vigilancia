package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AgrupamentoDTO;
import br.gov.mt.vigilancia.saude.service.AgrupamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de agrupamentos.
 */
@RestController
@RequestMapping("/agrupamentos")
@Tag(name = "Agrupamentos", description = "Consulta de agrupamentos")
@SecurityRequirement(name = "bearerAuth")
public class AgrupamentoController {

    @Autowired
    private AgrupamentoService agrupamentoService;

    @GetMapping
    @Operation(summary = "Listar agrupamentos", description = "Retorna todos os agrupamentos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<AgrupamentoDTO>> getAllAgrupamentos() {
        return ResponseEntity.ok(agrupamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgrupamentoDTO> getAgrupamentoById(@PathVariable Integer id) {
        return agrupamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgrupamentoDTO> createAgrupamento(@RequestBody AgrupamentoDTO agrupamentoDTO) {
        return ResponseEntity.ok(agrupamentoService.save(agrupamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgrupamentoDTO> updateAgrupamento(@PathVariable Integer id, @RequestBody AgrupamentoDTO agrupamentoDTO) {
        return agrupamentoService.findById(id)
                .map(existingAgrupamentoDTO -> {
                    agrupamentoDTO.setIdagrupamento(id);
                    return ResponseEntity.ok(agrupamentoService.save(agrupamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgrupamento(@PathVariable Integer id) {
        agrupamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
