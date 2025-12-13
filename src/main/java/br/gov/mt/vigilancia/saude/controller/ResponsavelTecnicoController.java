package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ResponsavelTecnicoDTO;
import br.gov.mt.vigilancia.saude.service.ResponsavelTecnicoService;
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
 * Controller para gerenciamento de responsáveis técnicos.
 */
@RestController
@RequestMapping("/responsaveis-tecnicos")
@RequiredArgsConstructor
@Tag(name = "Responsáveis Técnicos", description = "Consulta de responsáveis técnicos")
@SecurityRequirement(name = "bearerAuth")
public class ResponsavelTecnicoController {

    private final ResponsavelTecnicoService responsavelTecnicoService;

    @GetMapping
    @Operation(summary = "Listar responsáveis técnicos", description = "Retorna todos os responsáveis técnicos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ResponsavelTecnicoDTO>> findAll() {
        return ResponseEntity.ok(responsavelTecnicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar responsável técnico por ID", description = "Retorna um responsável técnico específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Responsável técnico encontrado")
    @ApiResponse(responseCode = "404", description = "Responsável técnico não encontrado")
    public ResponseEntity<ResponsavelTecnicoDTO> findById(@Parameter(description = "ID do responsável técnico") @PathVariable Integer id) {
        return ResponseEntity.ok(responsavelTecnicoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar responsável técnico", description = "Cria um novo responsável técnico")
    @ApiResponse(responseCode = "200", description = "Responsável técnico criado com sucesso")
    public ResponseEntity<ResponsavelTecnicoDTO> create(@Valid @RequestBody ResponsavelTecnicoDTO responsavelTecnicoDTO) {
        return ResponseEntity.ok(responsavelTecnicoService.save(responsavelTecnicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar responsável técnico", description = "Atualiza um responsável técnico existente")
    @ApiResponse(responseCode = "200", description = "Responsável técnico atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Responsável técnico não encontrado")
    public ResponseEntity<ResponsavelTecnicoDTO> update(@Parameter(description = "ID do responsável técnico") @PathVariable Integer id, @Valid @RequestBody ResponsavelTecnicoDTO responsavelTecnicoDTO) {
        return ResponseEntity.ok(responsavelTecnicoService.update(id, responsavelTecnicoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir responsável técnico", description = "Exclui um responsável técnico")
    @ApiResponse(responseCode = "204", description = "Responsável técnico excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Responsável técnico não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do responsável técnico") @PathVariable Integer id) {
        responsavelTecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
