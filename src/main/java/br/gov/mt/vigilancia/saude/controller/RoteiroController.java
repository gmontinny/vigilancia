package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RoteiroDTO;
import br.gov.mt.vigilancia.saude.service.RoteiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para consulta de roteiros de inspeção.
 */
@RestController
@RequestMapping("/roteiros")
@RequiredArgsConstructor
@Tag(name = "Roteiros", description = "Consulta de roteiros de inspeção")
@SecurityRequirement(name = "bearerAuth")
public class RoteiroController {

    private final RoteiroService roteiroService;

    @GetMapping
    @Operation(summary = "Listar roteiros", description = "Retorna todos os roteiros de inspeção cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<RoteiroDTO>> findAll() {
        return ResponseEntity.ok(roteiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar roteiro por ID", description = "Retorna um roteiro específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Roteiro encontrado")
    @ApiResponse(responseCode = "404", description = "Roteiro não encontrado")
    public ResponseEntity<RoteiroDTO> findById(@Parameter(description = "ID do roteiro") @PathVariable Integer id) {
        return ResponseEntity.ok(roteiroService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar roteiro", description = "Cria um novo roteiro de inspeção")
    @ApiResponse(responseCode = "200", description = "Roteiro criado com sucesso")
    public ResponseEntity<RoteiroDTO> create(@Valid @RequestBody RoteiroDTO roteiroDTO) {
        return ResponseEntity.ok(roteiroService.save(roteiroDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar roteiro", description = "Atualiza um roteiro existente")
    @ApiResponse(responseCode = "200", description = "Roteiro atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Roteiro não encontrado")
    public ResponseEntity<RoteiroDTO> update(@Parameter(description = "ID do roteiro") @PathVariable Integer id, @Valid @RequestBody RoteiroDTO roteiroDTO) {
        return ResponseEntity.ok(roteiroService.update(id, roteiroDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir roteiro", description = "Exclui um roteiro")
    @ApiResponse(responseCode = "204", description = "Roteiro excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Roteiro não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do roteiro") @PathVariable Integer id) {
        roteiroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
