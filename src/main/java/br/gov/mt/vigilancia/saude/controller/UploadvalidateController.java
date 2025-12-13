package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.UploadvalidateDTO;
import br.gov.mt.vigilancia.saude.service.UploadvalidateService;
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
@RequestMapping("/uploadvalidates")
@Tag(name = "Upload Validate", description = "Operações CRUD para validação de uploads")
public class UploadvalidateController {

    @Autowired
    private UploadvalidateService uploadvalidateService;

    @GetMapping
    @Operation(summary = "Listar validações de upload", description = "Retorna a lista completa de validações de upload")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<UploadvalidateDTO>> getAllUploadvalidates() {
        return ResponseEntity.ok(uploadvalidateService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar validação por ID", description = "Retorna uma validação de upload pelo seu identificador")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro encontrado"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadvalidateDTO> getUploadvalidateById(@Parameter(description = "ID da validação", example = "1") @PathVariable Integer id) {
        return uploadvalidateService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar validação de upload", description = "Cria uma nova validação de upload")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro criado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadvalidateDTO> createUploadvalidate(@Valid @RequestBody UploadvalidateDTO uploadvalidateDTO) {
        return ResponseEntity.ok(uploadvalidateService.save(uploadvalidateDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar validação de upload", description = "Atualiza uma validação de upload existente")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UploadvalidateDTO> updateUploadvalidate(@Parameter(description = "ID da validação", example = "1") @PathVariable Integer id, @Valid @RequestBody UploadvalidateDTO uploadvalidateDTO) {
        return uploadvalidateService.findById(id)
                .map(existingUploadvalidateDTO -> {
                    uploadvalidateDTO.setIduploadvalidate(id);
                    return ResponseEntity.ok(uploadvalidateService.save(uploadvalidateDTO));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir validação de upload", description = "Remove uma validação de upload pelo seu ID")
    @ApiResponses({@ApiResponse(responseCode = "204", description = "Exclusão realizada com sucesso"), @ApiResponse(responseCode = "401", description = "Não autorizado"), @ApiResponse(responseCode = "404", description = "Registro não encontrado")})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteUploadvalidate(@Parameter(description = "ID da validação", example = "1") @PathVariable Integer id) {
        uploadvalidateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}