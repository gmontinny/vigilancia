package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.CarteirinhaDTO;
import br.gov.mt.vigilancia.saude.service.CarteirinhaService;
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
@RequestMapping("/carteirinhas")
@Tag(name = "Carteirinhas", description = "Operações CRUD para carteirinhas de identificação")
public class CarteirinhaController {

    @Autowired
    private CarteirinhaService carteirinhaService;

    @GetMapping
    @Operation(summary = "Listar carteirinhas", description = "Retorna a lista completa de carteirinhas cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarteirinhaDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<CarteirinhaDTO>> getAllCarteirinhas() {
        return ResponseEntity.ok(carteirinhaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar carteirinha por ID", description = "Retorna uma carteirinha pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarteirinhaDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CarteirinhaDTO> getCarteirinhaById(
            @Parameter(description = "Identificador da carteirinha", example = "1") @PathVariable Integer id) {
        return carteirinhaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar carteirinha", description = "Cria uma nova carteirinha")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarteirinhaDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CarteirinhaDTO> createCarteirinha(@Valid @RequestBody CarteirinhaDTO carteirinhaDTO) {
        return ResponseEntity.ok(carteirinhaService.save(carteirinhaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar carteirinha", description = "Atualiza uma carteirinha existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarteirinhaDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CarteirinhaDTO> updateCarteirinha(
            @Parameter(description = "Identificador da carteirinha", example = "1") @PathVariable Integer id,
            @Valid @RequestBody CarteirinhaDTO carteirinhaDTO) {
        return carteirinhaService.findById(id)
                .map(existingCarteirinhaDTO -> {
                    carteirinhaDTO.setIdcarteirinha(id);
                    return ResponseEntity.ok(carteirinhaService.save(carteirinhaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir carteirinha", description = "Remove uma carteirinha pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteCarteirinha(
            @Parameter(description = "Identificador da carteirinha", example = "1") @PathVariable Integer id) {
        carteirinhaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
