package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Table(name = "licencia")
public class Licencia {

    @Id
    @SequenceGenerator(name = "licencia_idlicencia_seq", sequenceName = "licencia_idlicencia_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "licencia_idlicencia_seq")
    private Integer id;

    private LocalDate dataLicencia;

    private LocalDate dataVencimento;

    private Integer qtImpresso;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idveiculo")
    @NotNull(message = "Veículo é um campo obrigatório!")
    private Veiculo veiculo;

    private Integer status;
}
