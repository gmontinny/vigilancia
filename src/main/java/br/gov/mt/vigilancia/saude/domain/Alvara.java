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
@Table(name = "alvara")
public class Alvara {

    @Id
    @SequenceGenerator(name = "alvara_idalvara_seq", sequenceName = "alvara_idalvara_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alvara_idalvara_seq")
    private Integer id;

    private LocalDate dataAlvara;

    private LocalDate dataVencimento;

    private Integer qtImpresso;

    private String numeroProcesso;

    @ManyToOne
    @JoinColumn(name = "idestabelecimento")
    @NotNull(message = "Estabelecimento é um campo obrigatório!")
    private Estabelecimento estabelecimento;

    @NotNull(message = "Tipo de alvará é um campo obrigatório!")
    private Integer tipoAlvara;

    private Integer statusAlvara;
}
