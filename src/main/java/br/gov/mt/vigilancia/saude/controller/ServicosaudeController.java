package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ServicosaudeDTO;
import br.gov.mt.vigilancia.saude.service.ServicosaudeService;
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
@RequestMapping("/servicosaudes")
@Tag(name = "Serviços de Saúde", description = "Operações CRUD para serviços de saúde")
public class ServicosaudeController {

    @Autowired
    private ServicosaudeService servicosaudeService;

    @GetMapping
    @Operation(summary = "Listar serviços de saúde", description = "Retorna a lista completa de serviços de saúde cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicosaudeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ServicosaudeDTO>> getAllServicosaudes() {
        return ResponseEntity.ok(servicosaudeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço de saúde por ID", description = "Retorna um serviço de saúde pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicosaudeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ServicosaudeDTO> getServicosaudeById(@Parameter(description = "Identificador do serviço de saúde", example = "1") @PathVariable Integer id) {
        return servicosaudeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar serviço de saúde", description = "Cria um novo serviço de saúde")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicosaudeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ServicosaudeDTO> createServicosaude(@Valid @RequestBody ServicosaudeDTO servicosaudeDTO) {
        return ResponseEntity.ok(servicosaudeService.save(servicosaudeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar serviço de saúde", description = "Atualiza um serviço de saúde existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicosaudeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ServicosaudeDTO> updateServicosaude(@Parameter(description = "Identificador do serviço de saúde", example = "1") @PathVariable Integer id, @Valid @RequestBody ServicosaudeDTO servicosaudeDTO) {
        return servicosaudeService.findById(id)
                .map(existingServicosaudeDTO -> {
                    servicosaudeDTO.setIdservicosaude(id);
                    return ResponseEntity.ok(servicosaudeService.save(servicosaudeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir serviço de saúde", description = "Remove um serviço de saúde pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteServicosaude(@Parameter(description = "Identificador do serviço de saúde", example = "1") @PathVariable Integer id) {
        servicosaudeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
