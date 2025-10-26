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
import jakarta.validation.constraints.NotNull;
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
@Table(name = "responsavel_tecnico")
public class ResponsavelTecnico {

    @Id
    @SequenceGenerator(name = "responsavel_tecnico_id_seq", sequenceName = "responsavel_tecnico_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsavel_tecnico_id_seq")
    private Integer id;

    @NotBlank(message = "Nome do técnico é um campo obrigatório!")
    @Size(min = 5, message = "Nome do técnico deve ter no mínimo 5 caracteres!")
    private String nome;

    @NotBlank(message = "CPF é um campo obrigatório!")
    private String cpf;

    @NotBlank(message = "Número do conselho é um campo obrigatório!")
    private String numeroConselho;

    private String numeroProcesso;

    @ManyToOne
    @JoinColumn(name = "id_conselho")
    @NotNull(message = "Conselho é um campo obrigatório!")
    private Conselho conselho;
}
