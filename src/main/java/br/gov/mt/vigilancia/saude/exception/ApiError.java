package br.gov.mt.vigilancia.saude.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;
import java.util.List;

@Schema(name = "ApiError", description = "Modelo de erro padrão retornado pela API")
public record ApiError(
        @Schema(description = "Data/hora do erro (UTC)", example = "2025-11-29T08:37:00Z")
        OffsetDateTime timestamp,

        @Schema(description = "Código HTTP", example = "400")
        int status,

        @Schema(description = "Texto do status HTTP", example = "Bad Request")
        String error,

        @Schema(description = "Mensagem detalhada do erro", example = "Validation failed")
        String message,

        @Schema(description = "Path da requisição", example = "/api/recursos/123")
        String path,

        @Schema(description = "Lista de erros de campo quando houver validação")
        List<FieldError> fieldErrors
) {
    @Schema(name = "FieldError", description = "Erro específico de um campo")
    public record FieldError(
            @Schema(description = "Nome do campo", example = "email") String field,
            @Schema(description = "Mensagem do erro", example = "must not be blank") String message
    ) {}
}
