package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.EnderecoDTO;
import br.gov.mt.vigilancia.saude.service.EnderecoService;
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
 * Controller para gerenciamento de endereços.
 */
@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
@Tag(name = "Endereços", description = "Consulta de endereços")
@SecurityRequirement(name = "bearerAuth")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    @Operation(summary = "Listar endereços", description = "Retorna todos os endereços cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar endereço por ID", description = "Retorna um endereço pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Endereço encontrado")
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    public ResponseEntity<EnderecoDTO> findById(@Parameter(description = "ID do endereço", example = "1") @PathVariable Integer id) {
        return enderecoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar endereço", description = "Cria um novo endereço")
    @ApiResponse(responseCode = "200", description = "Endereço criado com sucesso")
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok(enderecoService.save(enderecoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar endereço", description = "Atualiza um endereço existente")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    public ResponseEntity<EnderecoDTO> update(@Parameter(description = "ID do endereço", example = "1") @PathVariable Integer id, @Valid @RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.findById(id)
                .map(existing -> {
                    enderecoDTO.setId(id);
                    return ResponseEntity.ok(enderecoService.save(enderecoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir endereço", description = "Remove um endereço pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Endereço excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do endereço", example = "1") @PathVariable Integer id) {
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
