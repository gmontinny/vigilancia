package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RetinoicoDTO;
import br.gov.mt.vigilancia.saude.service.RetinoicoService;
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
@RequestMapping("/retinoicos")
@Tag(name = "Retinoico", description = "Operações CRUD para produtos retinoicos")
public class RetinoicoController {

    @Autowired
    private RetinoicoService retinoicoService;

    @GetMapping
    @Operation(summary = "Listar produtos retinoicos", description = "Retorna a lista completa de produtos retinoicos")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<RetinoicoDTO>> getAllRetinoicos() {
        return ResponseEntity.ok(retinoicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto retinoico por ID", description = "Retorna um produto retinoico pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RetinoicoDTO> getRetinoicoById(@Parameter(description = "ID do produto", example = "1") @PathVariable Integer id) {
        return retinoicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar produto retinoico", description = "Cria um novo produto retinoico")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RetinoicoDTO> createRetinoico(@Valid @RequestBody RetinoicoDTO retinoicoDTO) {
        return ResponseEntity.ok(retinoicoService.save(retinoicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto retinoico", description = "Atualiza um produto retinoico existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<RetinoicoDTO> updateRetinoico(@Parameter(description = "ID do produto", example = "1") @PathVariable Integer id, @Valid @RequestBody RetinoicoDTO retinoicoDTO) {
        return retinoicoService.findById(id)
                .map(existingRetinoicoDTO -> {
                    retinoicoDTO.setIdretinoico(id);
                    return ResponseEntity.ok(retinoicoService.save(retinoicoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir produto retinoico", description = "Remove um produto retinoico pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteRetinoico(@Parameter(description = "ID do produto", example = "1") @PathVariable Integer id) {
        retinoicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
