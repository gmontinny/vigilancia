package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AdministrativoDTO;
import br.gov.mt.vigilancia.saude.service.AdministrativoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de registros administrativos.
 */
@RestController
@RequestMapping("/administrativos")
@Tag(name = "Administrativos", description = "Gerenciamento de registros administrativos")
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth")
public class AdministrativoController {

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping
    @Operation(summary = "Listar administrativos",
            description = "Retorna a lista de registros administrativos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativoDTO.class)))
    })
    public ResponseEntity<List<AdministrativoDTO>> getAllAdministrativos() {
        return ResponseEntity.ok(administrativoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar administrativo por ID",
            description = "Retorna um registro administrativo quando encontrado pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<AdministrativoDTO> getAdministrativoById(
            @Parameter(description = "Identificador do administrativo", example = "1")
            @PathVariable Integer id) {
        return administrativoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar administrativo",
            description = "Cria um novo registro administrativo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativoDTO.class)))
    })
    public ResponseEntity<AdministrativoDTO> createAdministrativo(
            @RequestBody(description = "Dados do administrativo a ser criado", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody AdministrativoDTO administrativoDTO) {
        return ResponseEntity.ok(administrativoService.save(administrativoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar administrativo",
            description = "Atualiza um registro administrativo existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<AdministrativoDTO> updateAdministrativo(
            @Parameter(description = "Identificador do administrativo", example = "1")
            @PathVariable Integer id,
            @RequestBody(description = "Dados do administrativo para atualização", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody AdministrativoDTO administrativoDTO) {
        return administrativoService.findById(id)
                .map(existingAdministrativoDTO -> {
                    administrativoDTO.setIdadministrativo(id);
                    return ResponseEntity.ok(administrativoService.save(administrativoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir administrativo",
            description = "Remove um registro administrativo pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<Void> deleteAdministrativo(
            @Parameter(description = "Identificador do administrativo", example = "1")
            @PathVariable Integer id) {
        administrativoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
