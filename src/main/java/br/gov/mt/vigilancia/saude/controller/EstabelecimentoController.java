package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EstabelecimentoDTO;
import br.gov.mt.vigilancia.saude.service.EstabelecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciamento de estabelecimentos.
 * Fornece endpoints para consulta de estabelecimentos sujeitos à vigilância sanitária.
 */
@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
@Tag(name = "Estabelecimentos", description = "Gerenciamento de estabelecimentos sujeitos à vigilância sanitária")
@SecurityRequirement(name = "bearerAuth")
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    @GetMapping
    @Operation(summary = "Listar estabelecimentos", description = "Retorna a lista de todos os estabelecimentos sujeitos à vigilância sanitária")
    @ApiResponse(responseCode = "200", description = "Lista de estabelecimentos retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<List<EstabelecimentoDTO>> findAll() {
        return ResponseEntity.ok(estabelecimentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estabelecimento por ID", description = "Retorna um estabelecimento pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Estabelecimento encontrado")
    @ApiResponse(responseCode = "404", description = "Estabelecimento não encontrado")
    public ResponseEntity<EstabelecimentoDTO> findById(@Parameter(description = "ID do estabelecimento", example = "1") @PathVariable Integer id) {
        return estabelecimentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar estabelecimento", description = "Cria um novo estabelecimento")
    @ApiResponse(responseCode = "200", description = "Estabelecimento criado com sucesso")
    public ResponseEntity<EstabelecimentoDTO> create(@Valid @RequestBody EstabelecimentoDTO estabelecimentoDTO) {
        return ResponseEntity.ok(estabelecimentoService.save(estabelecimentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar estabelecimento", description = "Atualiza um estabelecimento existente")
    @ApiResponse(responseCode = "200", description = "Estabelecimento atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Estabelecimento não encontrado")
    public ResponseEntity<EstabelecimentoDTO> update(@Parameter(description = "ID do estabelecimento", example = "1") @PathVariable Integer id, @Valid @RequestBody EstabelecimentoDTO estabelecimentoDTO) {
        return estabelecimentoService.findById(id)
                .map(existing -> {
                    estabelecimentoDTO.setId(id);
                    return ResponseEntity.ok(estabelecimentoService.save(estabelecimentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir estabelecimento", description = "Remove um estabelecimento pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Estabelecimento excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Estabelecimento não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do estabelecimento", example = "1") @PathVariable Integer id) {
        estabelecimentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
