package br.gov.mt.vigilancia.saude.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsuarioDTO {
    @Schema(description = "Identificador do usuário", example = "1")
    private Integer id;

    @Schema(description = "Nome completo do usuário", example = "Maria da Silva")
    private String nome;

    @Schema(description = "CPF do usuário", example = "123.456.789-00")
    private String cpf;

    @Schema(description = "E-mail do usuário", example = "maria@exemplo.com")
    private String email;

    @Schema(description = "Senha do usuário (apenas para escrita)", accessMode = Schema.AccessMode.WRITE_ONLY, example = "Secr3ta!")
    private String senha;

    @Schema(description = "Celular do usuário", example = "+55 65 99999-0000")
    private String celular;

    @Schema(description = "URL da imagem/foto do usuário")
    private String imagem;

    @Schema(description = "Sexo (0=Não informado, 1=Masculino, 2=Feminino)", example = "1")
    private Integer sexo;

    @Schema(description = "Indica se é advogado (0=Não, 1=Sim)", example = "0")
    private Integer advogado;

    @Schema(description = "Status do usuário", example = "1")
    private Integer status;

    @Schema(description = "Tipo de usuário", example = "1")
    private Integer tipo;

    @Schema(description = "Indica se é auditor (0=Não, 1=Sim)", example = "0")
    private Integer auditor;

    @Schema(description = "Indica se é administrativo (0=Não, 1=Sim)", example = "0")
    private Integer administrativo;

    @Schema(description = "Status de envio (uso interno)", example = "0")
    private Integer statusEnvio;

    @Schema(description = "Indica se é coordenador (0=Não, 1=Sim)", example = "0")
    private Integer coordenador;

    @Schema(description = "Indica se é do RH (0=Não, 1=Sim)", example = "0")
    private Integer recursoHumano;

    // Expor apenas se o 2FA está habilitado; não inclui o segredo TOTP
    @Schema(description = "Indica se o 2FA (TOTP) está habilitado", example = "false")
    private Boolean totpEnabled;

    private List<EnderecoDTO> enderecos;
    private List<FiscalDTO> fiscais;
    private List<PermissaoDTO> permissoes;
}
