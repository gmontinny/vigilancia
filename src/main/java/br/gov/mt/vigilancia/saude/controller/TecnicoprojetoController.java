package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TecnicoprojetoDTO;
import br.gov.mt.vigilancia.saude.service.TecnicoprojetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/tecnicoprojetos")
@Tag(name = "Técnico Projeto", description = "Operações CRUD para técnicos de projeto")
public class TecnicoprojetoController {

    @Autowired
    private TecnicoprojetoService tecnicoprojetoService;

    @GetMapping
    @Operation(summary = "Listar técnicos de projeto", description = "Retorna a lista completa de técnicos de projeto")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TecnicoprojetoDTO>> getAllTecnicoprojetos() {
        return ResponseEntity.ok(tecnicoprojetoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar técnico por ID", description = "Retorna um técnico de projeto pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TecnicoprojetoDTO> getTecnicoprojetoById(@Parameter(description = "ID do técnico", example = "1") @PathVariable Integer id) {
        return tecnicoprojetoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar técnico", description = "Cria um novo técnico de projeto")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TecnicoprojetoDTO> createTecnicoprojeto(@Valid @RequestBody TecnicoprojetoDTO tecnicoprojetoDTO) {
        return ResponseEntity.ok(tecnicoprojetoService.save(tecnicoprojetoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar técnico", description = "Atualiza um técnico de projeto existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TecnicoprojetoDTO> updateTecnicoprojeto(@Parameter(description = "ID do técnico", example = "1") @PathVariable Integer id, @Valid @RequestBody TecnicoprojetoDTO tecnicoprojetoDTO) {
        return tecnicoprojetoService.findById(id)
                .map(existingTecnicoprojetoDTO -> {
                    tecnicoprojetoDTO.setIdtecnicoprojeto(id);
                    return ResponseEntity.ok(tecnicoprojetoService.save(tecnicoprojetoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir técnico", description = "Remove um técnico de projeto pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTecnicoprojeto(@Parameter(description = "ID do técnico", example = "1") @PathVariable Integer id) {
        tecnicoprojetoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
