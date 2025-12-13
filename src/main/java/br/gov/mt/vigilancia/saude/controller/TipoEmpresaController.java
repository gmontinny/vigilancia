package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TipoEmpresaDTO;
import br.gov.mt.vigilancia.saude.service.TipoEmpresaService;
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
 * Controller para gerenciamento de tipos de empresa.
 */
@RestController
@RequestMapping("/tipos-empresa")
@RequiredArgsConstructor
@Tag(name = "Tipos de Empresa", description = "Consulta de tipos de empresa")
@SecurityRequirement(name = "bearerAuth")
public class TipoEmpresaController {

    private final TipoEmpresaService tipoEmpresaService;

    @GetMapping
    @Operation(summary = "Listar tipos de empresa", description = "Retorna todos os tipos de empresa cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<TipoEmpresaDTO>> findAll() {
        return ResponseEntity.ok(tipoEmpresaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tipo de empresa por ID", description = "Retorna um tipo de empresa específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Tipo de empresa encontrado")
    @ApiResponse(responseCode = "404", description = "Tipo de empresa não encontrado")
    public ResponseEntity<TipoEmpresaDTO> findById(@Parameter(description = "ID do tipo de empresa") @PathVariable Integer id) {
        return ResponseEntity.ok(tipoEmpresaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar tipo de empresa", description = "Cria um novo tipo de empresa")
    @ApiResponse(responseCode = "200", description = "Tipo de empresa criado com sucesso")
    public ResponseEntity<TipoEmpresaDTO> create(@Valid @RequestBody TipoEmpresaDTO tipoEmpresaDTO) {
        return ResponseEntity.ok(tipoEmpresaService.save(tipoEmpresaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tipo de empresa", description = "Atualiza um tipo de empresa existente")
    @ApiResponse(responseCode = "200", description = "Tipo de empresa atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Tipo de empresa não encontrado")
    public ResponseEntity<TipoEmpresaDTO> update(@Parameter(description = "ID do tipo de empresa") @PathVariable Integer id, @Valid @RequestBody TipoEmpresaDTO tipoEmpresaDTO) {
        return ResponseEntity.ok(tipoEmpresaService.update(id, tipoEmpresaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir tipo de empresa", description = "Exclui um tipo de empresa")
    @ApiResponse(responseCode = "204", description = "Tipo de empresa excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Tipo de empresa não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do tipo de empresa") @PathVariable Integer id) {
        tipoEmpresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
