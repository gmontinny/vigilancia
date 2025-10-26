package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {

    @Id
    @SequenceGenerator(name = "estabelecimento_idestabelecimento_seq", sequenceName = "estabelecimento_idestabelecimento_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento_idestabelecimento_seq")
    private Integer id;

    @NotBlank(message = "Razão Social é um campo obrigatório!")
    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String ie;

    @NotBlank(message = "Email é um campo obrigatório!")
    @Email(message = "Email inválido!")
    private String email;

    private String telefone;

    private String celular;

    @NotBlank(message = "CEP é um campo obrigatório!")
    private String cep;

    @NotBlank(message = "Endereço é um campo obrigatório!")
    private String endereco;

    private Integer numero;

    @NotBlank(message = "Bairro é um campo obrigatório!")
    private String bairro;

    @NotBlank(message = "Área é um campo obrigatório!")
    private String area;

    private String latitude;

    private String longitude;

    private Long cm;

    private Long cnes;

    private String cpfResponsavel;

    private LocalDate dataCadastro;

    private Integer situacao;

    private Integer albergado;

    private Integer check;

    private Integer ambulante;

    private Integer enderecoFiscal;

    private Integer numeroAtividade;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idresponsavel")
    @NotNull(message = "Responsável Técnico é um campo obrigatório!")
    private ResponsavelTecnico responsavelTecnico;

    @ManyToOne
    @JoinColumn(name = "idtipoempresa")
    private TipoEmpresa tipoEmpresa;
}
