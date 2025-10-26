package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fabril")
public class Fabril {

    @Id
    @SequenceGenerator(name = "fabril_idfabril_seq", sequenceName = "fabril_idfabril_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fabril_idfabril_seq")
    private Integer id;

    @NotBlank(message = "Bairro é um campo obrigatório!")
    private String bairro;

    @NotBlank(message = "CEP é um campo obrigatório!")
    private String cep;

    @NotBlank(message = "CNPJ é um campo obrigatório!")
    private String cnpj;

    @NotBlank(message = "Email é um campo obrigatório!")
    @Email(message = "Email inválido!")
    private String email;

    private String fone;

    @NotBlank(message = "Município é um campo obrigatório!")
    private String municipio;

    private Integer numero;

    @NotBlank(message = "Razão Social é um campo obrigatório!")
    private String razaoSocial;

    @NotBlank(message = "Rua é um campo obrigatório!")
    private String rua;

    @NotNull(message = "Tipo fabril é um campo obrigatório!")
    private Integer tipoFabril;

    @NotBlank(message = "UF é um campo obrigatório!")
    private String uf;
}
