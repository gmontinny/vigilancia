package br.gov.mt.vigilancia.saude.controller;

import br.gov.mt.vigilancia.saude.dto.TipoEmpresaDTO;
import br.gov.mt.vigilancia.saude.service.TipoEmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller para gerenciamento de tipos de empresa.
 */
@RestController
@RequestMapping("/tipos-empresa")
@RequiredArgsConstructor
@Tag(name = "Tipos de Empresa", description = "Consulta de tipos de empresa")
@SecurityRequirement(name = "bearerAuth")
public class TipoEmpresaController {

    private final TipoEmpresaService tipoEmpresaService;

    @GetMapping
    @Operation(summary = "Listar tipos de empresa", description = "Retorna todos os tipos de empresa cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<TipoEmpresaDTO>> findAll() {
        return ResponseEntity.ok(tipoEmpresaService.findAll());
    }
}
