package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MotivoDTO;
import br.gov.mt.vigilancia.saude.service.MotivoService;
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
 * Controller para consulta de motivos.
 */
@RestController
@RequestMapping("/motivos")
@RequiredArgsConstructor
@Tag(name = "Motivos", description = "Consulta de motivos")
@SecurityRequirement(name = "bearerAuth")
public class MotivoController {

    private final MotivoService motivoService;

    @GetMapping
    @Operation(summary = "Listar motivos", description = "Retorna todos os motivos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<MotivoDTO>> findAll() {
        return ResponseEntity.ok(motivoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar motivo por ID", description = "Retorna um motivo específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Motivo encontrado")
    @ApiResponse(responseCode = "404", description = "Motivo não encontrado")
    public ResponseEntity<MotivoDTO> findById(@Parameter(description = "ID do motivo") @PathVariable Integer id) {
        return ResponseEntity.ok(motivoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar motivo", description = "Cria um novo motivo")
    @ApiResponse(responseCode = "200", description = "Motivo criado com sucesso")
    public ResponseEntity<MotivoDTO> create(@Valid @RequestBody MotivoDTO motivoDTO) {
        return ResponseEntity.ok(motivoService.save(motivoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar motivo", description = "Atualiza um motivo existente")
    @ApiResponse(responseCode = "200", description = "Motivo atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Motivo não encontrado")
    public ResponseEntity<MotivoDTO> update(@Parameter(description = "ID do motivo") @PathVariable Integer id, @Valid @RequestBody MotivoDTO motivoDTO) {
        return ResponseEntity.ok(motivoService.update(id, motivoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir motivo", description = "Exclui um motivo")
    @ApiResponse(responseCode = "204", description = "Motivo excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Motivo não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do motivo") @PathVariable Integer id) {
        motivoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
