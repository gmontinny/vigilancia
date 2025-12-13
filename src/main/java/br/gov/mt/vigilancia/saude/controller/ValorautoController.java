package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ValorautoDTO;
import br.gov.mt.vigilancia.saude.service.ValorautoService;
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
@RequestMapping("/valorautos")
@Tag(name = "Valor Auto", description = "Operações CRUD para valores de auto")
public class ValorautoController {

    @Autowired
    private ValorautoService valorautoService;

    @GetMapping
    @Operation(summary = "Listar valores de auto", description = "Retorna a lista completa de valores de auto")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ValorautoDTO>> getAllValorautos() {
        return ResponseEntity.ok(valorautoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar valor por ID", description = "Retorna um valor de auto pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ValorautoDTO> getValorautoById(@Parameter(description = "ID do valor", example = "1") @PathVariable Integer id) {
        return valorautoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar valor de auto", description = "Cria um novo valor de auto")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ValorautoDTO> createValorauto(@Valid @RequestBody ValorautoDTO valorautoDTO) {
        return ResponseEntity.ok(valorautoService.save(valorautoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar valor de auto", description = "Atualiza um valor de auto existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<ValorautoDTO> updateValorauto(@Parameter(description = "ID do valor", example = "1") @PathVariable Integer id, @Valid @RequestBody ValorautoDTO valorautoDTO) {
        return valorautoService.findById(id)
                .map(existingValorautoDTO -> {
                    valorautoDTO.setIdvalorauto(id);
                    return ResponseEntity.ok(valorautoService.save(valorautoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir valor de auto", description = "Remove um valor de auto pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteValorauto(@Parameter(description = "ID do valor", example = "1") @PathVariable Integer id) {
        valorautoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}