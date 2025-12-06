package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TabelainfracoeDTO;
import br.gov.mt.vigilancia.saude.service.TabelainfracoeService;
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
@RequestMapping("/tabelainfracoes")
@Tag(name = "Tabela de Infrações", description = "Operações CRUD para tabela de infrações")
public class TabelainfracoeController {

    @Autowired
    private TabelainfracoeService tabelainfracoeService;

    @GetMapping
    @Operation(summary = "Listar tabela de infrações", description = "Retorna a lista completa de infrações da tabela")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TabelainfracoeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TabelainfracoeDTO>> getAllTabelainfracoes() {
        return ResponseEntity.ok(tabelainfracoeService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar infração da tabela por ID", description = "Retorna uma infração da tabela pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TabelainfracoeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TabelainfracoeDTO> getTabelainfracoeById(@Parameter(description = "Identificador da infração da tabela", example = "1") @PathVariable Integer id) {
        return tabelainfracoeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar infração na tabela", description = "Cria uma nova infração na tabela")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TabelainfracoeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TabelainfracoeDTO> createTabelainfracoe(@Valid @RequestBody TabelainfracoeDTO tabelainfracoeDTO) {
        return ResponseEntity.ok(tabelainfracoeService.save(tabelainfracoeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar infração da tabela", description = "Atualiza uma infração da tabela existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TabelainfracoeDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TabelainfracoeDTO> updateTabelainfracoe(@Parameter(description = "Identificador da infração da tabela", example = "1") @PathVariable Integer id, @Valid @RequestBody TabelainfracoeDTO tabelainfracoeDTO) {
        return tabelainfracoeService.findById(id)
                .map(existingTabelainfracoeDTO -> {
                    tabelainfracoeDTO.setIdtabelainfracoes(id);
                    return ResponseEntity.ok(tabelainfracoeService.save(tabelainfracoeDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir infração da tabela", description = "Remove uma infração da tabela pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTabelainfracoe(@Parameter(description = "Identificador da infração da tabela", example = "1") @PathVariable Integer id) {
        tabelainfracoeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
