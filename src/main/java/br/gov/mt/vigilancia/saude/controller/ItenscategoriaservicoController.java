package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ItenscategoriaservicoDTO;
import br.gov.mt.vigilancia.saude.service.ItenscategoriaservicoService;
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
@RequestMapping("/itenscategoriaservicos")
@Tag(name = "Itens de Categoria de Serviço", description = "Operações CRUD para itens de categoria de serviço")
public class ItenscategoriaservicoController {

    @Autowired
    private ItenscategoriaservicoService itenscategoriaservicoService;

    @GetMapping
    @Operation(summary = "Listar itens de categoria de serviço", description = "Retorna a lista completa de itens de categoria de serviço cadastrados")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenscategoriaservicoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ItenscategoriaservicoDTO>> getAllItenscategoriaservicos() {
        return ResponseEntity.ok(itenscategoriaservicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item de categoria de serviço por ID", description = "Retorna um item de categoria de serviço pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenscategoriaservicoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItenscategoriaservicoDTO> getItenscategoriaservicoById(@Parameter(description = "Identificador do item de categoria de serviço", example = "1") @PathVariable Integer id) {
        return itenscategoriaservicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar item de categoria de serviço", description = "Cria um novo item de categoria de serviço")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenscategoriaservicoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItenscategoriaservicoDTO> createItenscategoriaservico(@Valid @RequestBody ItenscategoriaservicoDTO itenscategoriaservicoDTO) {
        return ResponseEntity.ok(itenscategoriaservicoService.save(itenscategoriaservicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de categoria de serviço", description = "Atualiza um item de categoria de serviço existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItenscategoriaservicoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ItenscategoriaservicoDTO> updateItenscategoriaservico(@Parameter(description = "Identificador do item de categoria de serviço", example = "1") @PathVariable Integer id, @Valid @RequestBody ItenscategoriaservicoDTO itenscategoriaservicoDTO) {
        return itenscategoriaservicoService.findById(id)
                .map(existingItenscategoriaservicoDTO -> {
                    itenscategoriaservicoDTO.setIditenscategoriaservico(id);
                    return ResponseEntity.ok(itenscategoriaservicoService.save(itenscategoriaservicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir item de categoria de serviço", description = "Remove um item de categoria de serviço pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteItenscategoriaservico(@Parameter(description = "Identificador do item de categoria de serviço", example = "1") @PathVariable Integer id) {
        itenscategoriaservicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
