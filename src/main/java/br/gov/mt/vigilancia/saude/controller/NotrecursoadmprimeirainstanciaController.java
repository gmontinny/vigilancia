package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.NotrecursoadmprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.service.NotrecursoadmprimeirainstanciaService;
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
@RequestMapping("/notrecursoadmprimeirainstancias")
@Tag(name = "Notificação Recurso Adm Primeira Instância", description = "Operações CRUD para notificações de recurso administrativo de primeira instância")
public class NotrecursoadmprimeirainstanciaController {

    @Autowired
    private NotrecursoadmprimeirainstanciaService notrecursoadmprimeirainstanciaService;

    @GetMapping
    @Operation(summary = "Listar notificações", description = "Retorna a lista completa de notificações de recurso administrativo de primeira instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<NotrecursoadmprimeirainstanciaDTO>> getAllNotrecursoadmprimeirainstancias() {
        return ResponseEntity.ok(notrecursoadmprimeirainstanciaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar notificação por ID", description = "Retorna uma notificação pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotrecursoadmprimeirainstanciaDTO> getNotrecursoadmprimeirainstanciaById(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        return notrecursoadmprimeirainstanciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar notificação", description = "Cria uma nova notificação de recurso administrativo de primeira instância")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotrecursoadmprimeirainstanciaDTO> createNotrecursoadmprimeirainstancia(@Valid @RequestBody NotrecursoadmprimeirainstanciaDTO notrecursoadmprimeirainstanciaDTO) {
        return ResponseEntity.ok(notrecursoadmprimeirainstanciaService.save(notrecursoadmprimeirainstanciaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar notificação", description = "Atualiza uma notificação existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<NotrecursoadmprimeirainstanciaDTO> updateNotrecursoadmprimeirainstancia(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id, @Valid @RequestBody NotrecursoadmprimeirainstanciaDTO notrecursoadmprimeirainstanciaDTO) {
        return notrecursoadmprimeirainstanciaService.findById(id)
                .map(existingNotrecursoadmprimeirainstanciaDTO -> {
                    notrecursoadmprimeirainstanciaDTO.setIdnotrecursoadmprimeirainstancia(id);
                    return ResponseEntity.ok(notrecursoadmprimeirainstanciaService.save(notrecursoadmprimeirainstanciaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir notificação", description = "Remove uma notificação pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteNotrecursoadmprimeirainstancia(@Parameter(description = "ID da notificação", example = "1") @PathVariable Integer id) {
        notrecursoadmprimeirainstanciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
