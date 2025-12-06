package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EmpresainfracoeDTO;
import br.gov.mt.vigilancia.saude.service.EmpresainfracoeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresainfracoes")
@Tag(name = "Empresa Infrações", description = "Operações CRUD para infrações de empresas")
public class EmpresainfracoeController {

    @Autowired
    private EmpresainfracoeService empresainfracoeService;

    @GetMapping
    @Operation(summary = "Listar infrações de empresas", description = "Retorna a lista completa de infrações de empresas cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmpresainfracoeDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<EmpresainfracoeDTO>> getAllEmpresainfracoes() {
        return ResponseEntity.ok(empresainfracoeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar infração de empresa por ID", description = "Retorna uma infração de empresa pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmpresainfracoeDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<EmpresainfracoeDTO> getEmpresainfracoeById(
            @Parameter(description = "Identificador da infração de empresa", example = "1") @PathVariable Integer id) {
        return empresainfracoeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar infração de empresa", description = "Cria uma nova infração de empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmpresainfracoeDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<EmpresainfracoeDTO> createEmpresainfracoe(@Valid @RequestBody EmpresainfracoeDTO empresainfracoeDTO) {
        return ResponseEntity.ok(empresainfracoeService.save(empresainfracoeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar infração de empresa", description = "Atualiza uma infração de empresa existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmpresainfracoeDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<EmpresainfracoeDTO> updateEmpresainfracoe(
            @Parameter(description = "Identificador da infração de empresa", example = "1") @PathVariable Integer id,
            @Valid @RequestBody EmpresainfracoeDTO empresainfracoeDTO) {
        return empresainfracoeService.findById(id)
                .map(existingEmpresainfracoeDTO -> {
                    empresainfracoeDTO.setIdempresainfracoes(id);
                    return ResponseEntity.ok(empresainfracoeService.save(empresainfracoeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir infração de empresa", description = "Remove uma infração de empresa pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteEmpresainfracoe(
            @Parameter(description = "Identificador da infração de empresa", example = "1") @PathVariable Integer id) {
        empresainfracoeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
