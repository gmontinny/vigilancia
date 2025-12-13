package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.RespostaDTO;
import br.gov.mt.vigilancia.saude.service.RespostaService;
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
 * Controller para consulta de respostas.
 */
@RestController
@RequestMapping("/respostas")
@RequiredArgsConstructor
@Tag(name = "Respostas", description = "Consulta de respostas")
@SecurityRequirement(name = "bearerAuth")
public class RespostaController {

    private final RespostaService respostaService;

    @GetMapping
    @Operation(summary = "Listar respostas", description = "Retorna todas as respostas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<RespostaDTO>> findAll() {
        return ResponseEntity.ok(respostaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar resposta por ID", description = "Retorna uma resposta pelo seu identificador")
    @ApiResponse(responseCode = "200", description = "Resposta encontrada")
    @ApiResponse(responseCode = "404", description = "Resposta não encontrada")
    public ResponseEntity<RespostaDTO> findById(@Parameter(description = "ID da resposta", example = "1") @PathVariable Integer id) {
        return respostaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar resposta", description = "Cria uma nova resposta")
    @ApiResponse(responseCode = "200", description = "Resposta criada com sucesso")
    public ResponseEntity<RespostaDTO> create(@Valid @RequestBody RespostaDTO respostaDTO) {
        return ResponseEntity.ok(respostaService.save(respostaDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar resposta", description = "Atualiza uma resposta existente")
    @ApiResponse(responseCode = "200", description = "Resposta atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Resposta não encontrada")
    public ResponseEntity<RespostaDTO> update(@Parameter(description = "ID da resposta", example = "1") @PathVariable Integer id, @Valid @RequestBody RespostaDTO respostaDTO) {
        return respostaService.findById(id)
                .map(existing -> {
                    respostaDTO.setId(id);
                    return ResponseEntity.ok(respostaService.save(respostaDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir resposta", description = "Remove uma resposta pelo seu ID")
    @ApiResponse(responseCode = "204", description = "Resposta excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Resposta não encontrada")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da resposta", example = "1") @PathVariable Integer id) {
        respostaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
