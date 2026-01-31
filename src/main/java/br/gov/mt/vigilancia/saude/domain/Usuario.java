package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @SequenceGenerator(name = "usuario_idusuario_seq", sequenceName = "usuario_idusuario_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_idusuario_seq")
    private Integer id;

    @NotBlank(message = "Nome é um campo obrigatório!")
    @Size(min = 5, message = "Nome deve ter no mínimo 5 caracteres!")
    private String nome;

    @NotBlank(message = "CPF é um campo obrigatório!")
    private String cpf;

    @NotBlank(message = "Email é um campo obrigatório!")
    @Email(message = "Email inválido!")
    private String email;

    @NotBlank(message = "Senha é um campo obrigatório!")
    @Size(min = 5, message = "Senha deve ter no mínimo 5 caracteres!")
    private String senha;

    private String celular;

    private String imagem;

    private Integer sexo;

    private Integer advogado;

    @NotNull(message = "Status é um campo obrigatório!")
    private Integer status;

    @NotNull(message = "Tipo é um campo obrigatório!")
    private Integer tipo;

    private Integer auditor;

    private Integer administrativo;

    private Integer statusEnvio;

    private Integer coordenador;

    private Integer recursoHumano;

    @OneToMany(mappedBy = "usuario")
    private List<Estabelecimento> estabelecimentos;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "usuario")
    private List<Fiscal> fiscais;

    @OneToMany(mappedBy = "usuario")
    private List<Permissao> permissoes;

    // 2FA (TOTP)
    // Segredo TOTP do usuário (não deve ser exposto via API)
    private String totpSecret;

    // Indica se o TOTP está habilitado para o usuário
    @Builder.Default
    private Boolean totpEnabled = false;
}
