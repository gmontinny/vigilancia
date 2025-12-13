package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UsuarioDTO;
import br.gov.mt.vigilancia.saude.service.UsuarioService;
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
 * Controller para gerenciamento de usuários do sistema.
 * Fornece endpoints para consulta de usuários cadastrados.
 */
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Gerenciamento de usuários do sistema")
@SecurityRequirement(name = "bearerAuth")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Listar usuários", description = "Retorna a lista de todos os usuários cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    @ApiResponse(responseCode = "401", description = "Não autorizado")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<UsuarioDTO> findById(@Parameter(description = "ID do usuário", example = "1") @PathVariable Integer id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar usuário", description = "Cria um novo usuário no sistema")
    @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso")
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.save(usuarioDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário", description = "Atualiza um usuário existente")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<UsuarioDTO> update(@Parameter(description = "ID do usuário", example = "1") @PathVariable Integer id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.findById(id)
                .map(existing -> {
                    usuarioDTO.setId(id);
                    return ResponseEntity.ok(usuarioService.save(usuarioDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir usuário", description = "Remove um usuário pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do usuário", example = "1") @PathVariable Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
