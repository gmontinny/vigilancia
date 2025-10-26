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
@Table(name = "baixa")
public class Baixa {

    @Id
    @SequenceGenerator(name = "baixa_idbaixa_seq", sequenceName = "baixa_idbaixa_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baixa_idbaixa_seq")
    private Integer id;

    private LocalDate dataBaixa;

    @ManyToOne
    @JoinColumn(name = "idestabelecimento")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "idresponsavel")
    @NotNull(message = "Responsável Técnico é um campo obrigatório!")
    private ResponsavelTecnico responsavelTecnico;

    private String numeroProcesso;
}
