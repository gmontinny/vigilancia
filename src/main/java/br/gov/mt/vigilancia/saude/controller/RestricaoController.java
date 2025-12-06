package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RestricaoDTO;
import br.gov.mt.vigilancia.saude.service.RestricaoService;
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
@RequestMapping("/restricoes")
@Tag(name = "Restrições", description = "Operações CRUD para restrições")
public class RestricaoController {

    @Autowired
    private RestricaoService restricaoService;

    @GetMapping
    @Operation(summary = "Listar restrições", description = "Retorna a lista completa de restrições cadastradas")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestricaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<RestricaoDTO>> getAllRestricoes() {
        return ResponseEntity.ok(restricaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar restrição por ID", description = "Retorna uma restrição pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestricaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RestricaoDTO> getRestricaoById(@Parameter(description = "Identificador da restrição", example = "1") @PathVariable Integer id) {
        return restricaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar restrição", description = "Cria uma nova restrição")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestricaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RestricaoDTO> createRestricao(@Valid @RequestBody RestricaoDTO restricaoDTO) {
        return ResponseEntity.ok(restricaoService.save(restricaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar restrição", description = "Atualiza uma restrição existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestricaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RestricaoDTO> updateRestricao(@Parameter(description = "Identificador da restrição", example = "1") @PathVariable Integer id, @Valid @RequestBody RestricaoDTO restricaoDTO) {
        return restricaoService.findById(id)
                .map(existingRestricaoDTO -> {
                    restricaoDTO.setIdrestricao(id);
                    return ResponseEntity.ok(restricaoService.save(restricaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir restrição", description = "Remove uma restrição pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteRestricao(@Parameter(description = "Identificador da restrição", example = "1") @PathVariable Integer id) {
        restricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
