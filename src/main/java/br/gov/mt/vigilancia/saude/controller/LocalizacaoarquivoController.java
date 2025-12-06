package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.LocalizacaoarquivoDTO;
import br.gov.mt.vigilancia.saude.service.LocalizacaoarquivoService;
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
@RequestMapping("/localizacaoarquivos")
@Tag(name = "Localização de Arquivos", description = "Operações CRUD para localização de arquivos")
public class LocalizacaoarquivoController {

    @Autowired
    private LocalizacaoarquivoService localizacaoarquivoService;

    @GetMapping
    @Operation(summary = "Listar localizações de arquivos", description = "Retorna a lista completa de localizações de arquivos cadastradas")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocalizacaoarquivoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<LocalizacaoarquivoDTO>> getAllLocalizacaoarquivos() {
        return ResponseEntity.ok(localizacaoarquivoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar localização de arquivo por ID", description = "Retorna uma localização de arquivo pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocalizacaoarquivoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<LocalizacaoarquivoDTO> getLocalizacaoarquivoById(@Parameter(description = "Identificador da localização de arquivo", example = "1") @PathVariable Integer id) {
        return localizacaoarquivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar localização de arquivo", description = "Cria uma nova localização de arquivo")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocalizacaoarquivoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<LocalizacaoarquivoDTO> createLocalizacaoarquivo(@Valid @RequestBody LocalizacaoarquivoDTO localizacaoarquivoDTO) {
        return ResponseEntity.ok(localizacaoarquivoService.save(localizacaoarquivoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar localização de arquivo", description = "Atualiza uma localização de arquivo existente pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocalizacaoarquivoDTO.class))), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<LocalizacaoarquivoDTO> updateLocalizacaoarquivo(@Parameter(description = "Identificador da localização de arquivo", example = "1") @PathVariable Integer id, @Valid @RequestBody LocalizacaoarquivoDTO localizacaoarquivoDTO) {
        return localizacaoarquivoService.findById(id)
                .map(existingLocalizacaoarquivoDTO -> {
                    localizacaoarquivoDTO.setIdlocalizacaoarquivo(id);
                    return ResponseEntity.ok(localizacaoarquivoService.save(localizacaoarquivoDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir localização de arquivo", description = "Remove uma localização de arquivo pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado - Token JWT inválido"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteLocalizacaoarquivo(@Parameter(description = "Identificador da localização de arquivo", example = "1") @PathVariable Integer id) {
        localizacaoarquivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
