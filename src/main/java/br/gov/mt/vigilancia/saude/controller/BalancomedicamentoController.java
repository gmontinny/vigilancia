package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.BalancomedicamentoDTO;
import br.gov.mt.vigilancia.saude.service.BalancomedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balancomedicamentos")
@Tag(name = "Balanço de Medicamentos", description = "Operações de consulta e manutenção de balanços de medicamentos")
public class BalancomedicamentoController {

    @Autowired
    private BalancomedicamentoService balancomedicamentoService;

    @GetMapping
    @Operation(summary = "Listar balanços de medicamentos",
            description = "Retorna a lista de balanços de medicamentos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BalancomedicamentoDTO.class)))
    })
    public ResponseEntity<List<BalancomedicamentoDTO>> getAllBalancomedicamentos() {
        return ResponseEntity.ok(balancomedicamentoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar balanço por ID",
            description = "Retorna um balanço de medicamentos quando encontrado pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BalancomedicamentoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<BalancomedicamentoDTO> getBalancomedicamentoById(
            @Parameter(description = "Identificador do balanço de medicamentos", example = "1")
            @PathVariable Integer id) {
        return balancomedicamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar balanço de medicamentos",
            description = "Cria um novo registro de balanço de medicamentos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BalancomedicamentoDTO.class)))
    })
    public ResponseEntity<BalancomedicamentoDTO> createBalancomedicamento(
            @RequestBody(description = "Dados do balanço de medicamentos a ser criado", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BalancomedicamentoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody BalancomedicamentoDTO balancomedicamentoDTO) {
        return ResponseEntity.ok(balancomedicamentoService.save(balancomedicamentoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar balanço de medicamentos",
            description = "Atualiza um registro de balanço de medicamentos existente pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BalancomedicamentoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<BalancomedicamentoDTO> updateBalancomedicamento(
            @Parameter(description = "Identificador do balanço de medicamentos", example = "1")
            @PathVariable Integer id,
            @RequestBody(description = "Dados do balanço de medicamentos para atualização", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BalancomedicamentoDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody BalancomedicamentoDTO balancomedicamentoDTO) {
        return balancomedicamentoService.findById(id)
                .map(existingBalancomedicamentoDTO -> {
                    balancomedicamentoDTO.setIdbalanco(id);
                    return ResponseEntity.ok(balancomedicamentoService.save(balancomedicamentoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir balanço de medicamentos",
            description = "Remove um registro de balanço de medicamentos pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado")
    })
    public ResponseEntity<Void> deleteBalancomedicamento(
            @Parameter(description = "Identificador do balanço de medicamentos", example = "1")
            @PathVariable Integer id) {
        balancomedicamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
