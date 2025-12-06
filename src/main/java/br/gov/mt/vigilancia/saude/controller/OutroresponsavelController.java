package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.OutroresponsavelDTO;
import br.gov.mt.vigilancia.saude.service.OutroresponsavelService;
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
@RequestMapping("/outroresponsaveis")
@Tag(name = "Outro Responsável", description = "Operações CRUD para outros responsáveis")
public class OutroresponsavelController {

    @Autowired
    private OutroresponsavelService outroresponsavelService;

    @GetMapping
    @Operation(summary = "Listar outros responsáveis", description = "Retorna a lista completa de outros responsáveis")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<OutroresponsavelDTO>> getAllOutroresponsaveis() {
        return ResponseEntity.ok(outroresponsavelService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar responsável por ID", description = "Retorna um outro responsável pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<OutroresponsavelDTO> getOutroresponsavelById(@Parameter(description = "ID do responsável", example = "1") @PathVariable Integer id) {
        return outroresponsavelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar responsável", description = "Cria um novo outro responsável")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<OutroresponsavelDTO> createOutroresponsavel(@Valid @RequestBody OutroresponsavelDTO outroresponsavelDTO) {
        return ResponseEntity.ok(outroresponsavelService.save(outroresponsavelDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar responsável", description = "Atualiza um outro responsável existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<OutroresponsavelDTO> updateOutroresponsavel(@Parameter(description = "ID do responsável", example = "1") @PathVariable Integer id, @Valid @RequestBody OutroresponsavelDTO outroresponsavelDTO) {
        return outroresponsavelService.findById(id)
                .map(existingOutroresponsavelDTO -> {
                    outroresponsavelDTO.setIdoutrosresponsaveis(id);
                    return ResponseEntity.ok(outroresponsavelService.save(outroresponsavelDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir responsável", description = "Remove um outro responsável pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteOutroresponsavel(@Parameter(description = "ID do responsável", example = "1") @PathVariable Integer id) {
        outroresponsavelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
