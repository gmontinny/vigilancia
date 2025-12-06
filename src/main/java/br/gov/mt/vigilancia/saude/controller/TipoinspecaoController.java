package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TipoinspecaoDTO;
import br.gov.mt.vigilancia.saude.service.TipoinspecaoService;
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
@RequestMapping("/tiposinspecao")
@Tag(name = "Tipos de Inspeção", description = "Operações CRUD para tipos de inspeção")
public class TipoinspecaoController {

    @Autowired
    private TipoinspecaoService tipoinspecaoService;

    @GetMapping
    @Operation(summary = "Listar tipos de inspeção", description = "Retorna a lista completa de tipos de inspeção cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoinspecaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TipoinspecaoDTO>> getAllTipoinspecoes() {
        return ResponseEntity.ok(tipoinspecaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tipo de inspeção por ID", description = "Retorna um tipo de inspeção pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoinspecaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TipoinspecaoDTO> getTipoinspecaoById(@Parameter(description = "Identificador do tipo de inspeção", example = "1") @PathVariable Integer id) {
        return tipoinspecaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar tipo de inspeção", description = "Cria um novo tipo de inspeção")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoinspecaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TipoinspecaoDTO> createTipoinspecao(@Valid @RequestBody TipoinspecaoDTO tipoinspecaoDTO) {
        return ResponseEntity.ok(tipoinspecaoService.save(tipoinspecaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tipo de inspeção", description = "Atualiza um tipo de inspeção existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoinspecaoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TipoinspecaoDTO> updateTipoinspecao(@Parameter(description = "Identificador do tipo de inspeção", example = "1") @PathVariable Integer id, @Valid @RequestBody TipoinspecaoDTO tipoinspecaoDTO) {
        return tipoinspecaoService.findById(id)
                .map(existingTipoinspecaoDTO -> {
                    tipoinspecaoDTO.setIdtipoinspecao(id);
                    return ResponseEntity.ok(tipoinspecaoService.save(tipoinspecaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir tipo de inspeção", description = "Remove um tipo de inspeção pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTipoinspecao(@Parameter(description = "Identificador do tipo de inspeção", example = "1") @PathVariable Integer id) {
        tipoinspecaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
