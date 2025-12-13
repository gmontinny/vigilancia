package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.ServicoDTO;
import br.gov.mt.vigilancia.saude.service.ServicoService;
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
 * Controller para consulta de serviços.
 */
@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
@Tag(name = "Serviços", description = "Consulta de serviços")
@SecurityRequirement(name = "bearerAuth")
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    @Operation(summary = "Listar serviços", description = "Retorna todos os serviços cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ServicoDTO>> findAll() {
        return ResponseEntity.ok(servicoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por ID", description = "Retorna um serviço específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Serviço encontrado")
    @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    public ResponseEntity<ServicoDTO> findById(@Parameter(description = "ID do serviço") @PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar serviço", description = "Cria um novo serviço")
    @ApiResponse(responseCode = "200", description = "Serviço criado com sucesso")
    public ResponseEntity<ServicoDTO> create(@Valid @RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.ok(servicoService.save(servicoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar serviço", description = "Atualiza um serviço existente")
    @ApiResponse(responseCode = "200", description = "Serviço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    public ResponseEntity<ServicoDTO> update(@Parameter(description = "ID do serviço") @PathVariable Integer id, @Valid @RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.ok(servicoService.update(id, servicoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir serviço", description = "Exclui um serviço")
    @ApiResponse(responseCode = "204", description = "Serviço excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    public ResponseEntity<Void> delete(@Parameter(description = "ID do serviço") @PathVariable Integer id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
