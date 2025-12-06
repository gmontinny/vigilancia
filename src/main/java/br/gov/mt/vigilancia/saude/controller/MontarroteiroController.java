package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.MontarroteiroDTO;
import br.gov.mt.vigilancia.saude.service.MontarroteiroService;
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
@RequestMapping("/montarroteiros")
@Tag(name = "Montar Roteiros", description = "Operações CRUD para montagem de roteiros")
public class MontarroteiroController {

    @Autowired
    private MontarroteiroService montarroteiroService;

    @GetMapping
    @Operation(summary = "Listar roteiros montados", description = "Retorna a lista completa de roteiros montados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MontarroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<MontarroteiroDTO>> getAllMontarroteiros() {
        return ResponseEntity.ok(montarroteiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar roteiro montado por ID", description = "Retorna um roteiro montado pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MontarroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MontarroteiroDTO> getMontarroteiroById(@Parameter(description = "Identificador do roteiro montado", example = "1") @PathVariable Integer id) {
        return montarroteiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar roteiro montado", description = "Cria um novo roteiro montado")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MontarroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MontarroteiroDTO> createMontarroteiro(@Valid @RequestBody MontarroteiroDTO montarroteiroDTO) {
        return ResponseEntity.ok(montarroteiroService.save(montarroteiroDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar roteiro montado", description = "Atualiza um roteiro montado existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MontarroteiroDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MontarroteiroDTO> updateMontarroteiro(@Parameter(description = "Identificador do roteiro montado", example = "1") @PathVariable Integer id, @Valid @RequestBody MontarroteiroDTO montarroteiroDTO) {
        return montarroteiroService.findById(id)
                .map(existingMontarroteiroDTO -> {
                    montarroteiroDTO.setIdmontarroteiro(id);
                    return ResponseEntity.ok(montarroteiroService.save(montarroteiroDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir roteiro montado", description = "Remove um roteiro montado pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteMontarroteiro(@Parameter(description = "Identificador do roteiro montado", example = "1") @PathVariable Integer id) {
        montarroteiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
