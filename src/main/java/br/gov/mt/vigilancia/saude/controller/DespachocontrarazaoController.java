package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.DespachocontrarazaoDTO;
import br.gov.mt.vigilancia.saude.service.DespachocontrarazaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despachocontrarazoes")
@Tag(name = "Despacho Contrarrazão", description = "Operações de consulta e manutenção de despachos de contrarrazão")
public class DespachocontrarazaoController {

    @Autowired
    private DespachocontrarazaoService despachocontrarazaoService;

    @GetMapping
    @Operation(summary = "Listar despachos de contrarrazão", description = "Retorna a lista de despachos de contrarrazão cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DespachocontrarazaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<DespachocontrarazaoDTO>> getAllDespachocontrarazoes() {
        return ResponseEntity.ok(despachocontrarazaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar despacho por ID", description = "Retorna um despacho de contrarrazão pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DespachocontrarazaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachocontrarazaoDTO> getDespachocontrarazaoById(
            @Parameter(description = "Identificador do despacho de contrarrazão", example = "1")
            @PathVariable Integer id) {
        return despachocontrarazaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar despacho de contrarrazão", description = "Cria um novo despacho de contrarrazão")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DespachocontrarazaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachocontrarazaoDTO> createDespachocontrarazao(
            @RequestBody(description = "Dados do despacho de contrarrazão a ser criado", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DespachocontrarazaoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody DespachocontrarazaoDTO despachocontrarazaoDTO) {
        return ResponseEntity.ok(despachocontrarazaoService.save(despachocontrarazaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar despacho de contrarrazão", description = "Atualiza um despacho de contrarrazão existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DespachocontrarazaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DespachocontrarazaoDTO> updateDespachocontrarazao(
            @Parameter(description = "Identificador do despacho de contrarrazão", example = "1")
            @PathVariable Integer id,
            @RequestBody(description = "Dados do despacho de contrarrazão para atualização", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DespachocontrarazaoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody DespachocontrarazaoDTO despachocontrarazaoDTO) {
        return despachocontrarazaoService.findById(id)
                .map(existingDespachocontrarazaoDTO -> {
                    despachocontrarazaoDTO.setIddespachocontrarazao(id);
                    return ResponseEntity.ok(despachocontrarazaoService.save(despachocontrarazaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir despacho de contrarrazão", description = "Remove um despacho de contrarrazão pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteDespachocontrarazao(
            @Parameter(description = "Identificador do despacho de contrarrazão", example = "1")
            @PathVariable Integer id) {
        despachocontrarazaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
