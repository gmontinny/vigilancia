package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @SequenceGenerator(name = "endereco_idendereco_seq", sequenceName = "endereco_idendereco_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_idendereco_seq")
    private Integer id;

    @NotBlank(message = "Bairro é um campo obrigatório!")
    @Size(min = 3, message = "Bairro deve ter no mínimo 3 caracteres!")
    private String bairro;

    @NotBlank(message = "CEP é um campo obrigatório!")
    private String cep;

    private String complemento;

    private String logradouro;

    private Integer numero;

    private String longitude;

    private String latitude;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
}
