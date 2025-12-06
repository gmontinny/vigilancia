package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.AreainspecaoDTO;
import br.gov.mt.vigilancia.saude.service.AreainspecaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areainspecao")
@Tag(name = "Área de Inspeção", description = "Operações de consulta e manutenção de áreas de inspeção")
public class AreainspecaoController {

    @Autowired
    private AreainspecaoService areainspecaoService;

    @GetMapping
    @Operation(summary = "Listar áreas de inspeção", description = "Retorna a lista de áreas de inspeção cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AreainspecaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<AreainspecaoDTO>> getAllAreainspecao() {
        return ResponseEntity.ok(areainspecaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar área de inspeção por ID", description = "Retorna uma área de inspeção pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AreainspecaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AreainspecaoDTO> getAreainspecaoById(
            @Parameter(description = "Identificador da área de inspeção", example = "1")
            @PathVariable Integer id) {
        return areainspecaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar área de inspeção", description = "Cria uma nova área de inspeção")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AreainspecaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AreainspecaoDTO> createAreainspecao(
            @RequestBody(description = "Dados da área de inspeção a ser criada", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AreainspecaoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody AreainspecaoDTO areainspecaoDTO) {
        return ResponseEntity.ok(areainspecaoService.save(areainspecaoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar área de inspeção", description = "Atualiza uma área de inspeção existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AreainspecaoDTO.class))),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AreainspecaoDTO> updateAreainspecao(
            @Parameter(description = "Identificador da área de inspeção", example = "1")
            @PathVariable Integer id,
            @RequestBody(description = "Dados da área de inspeção para atualização", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AreainspecaoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody AreainspecaoDTO areainspecaoDTO) {
        return areainspecaoService.findById(id)
                .map(existingAreainspecaoDTO -> {
                    areainspecaoDTO.setIdareainspecao(id);
                    return ResponseEntity.ok(areainspecaoService.save(areainspecaoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir área de inspeção", description = "Remove uma área de inspeção pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteAreainspecao(
            @Parameter(description = "Identificador da área de inspeção", example = "1")
            @PathVariable Integer id) {
        areainspecaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
