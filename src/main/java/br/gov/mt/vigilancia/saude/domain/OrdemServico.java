package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordemservico")
public class OrdemServico {

    @Id
    @SequenceGenerator(name = "ordemservico_idordemservico_seq", sequenceName = "ordemservico_idordemservico_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordemservico_idordemservico_seq")
    private Integer id;

    private LocalDate dataFinal;

    private LocalDate dataInicial;

    private LocalDate dataOrdemServico;

    private LocalDate dataConclusao;

    private String usuarioConclusao;

    private Integer situacao;

    private String textoConclusao;

    private String textoProblema;

    private Integer prioridade;

    private Integer tls;

    private Integer tipo;

    private LocalTime horaOrdemServico;

    private String tipoDocumento;

    private String descricaoDocumento;

    @ManyToOne
    @JoinColumn(name = "idacao")
    private Acao acao;

    @ManyToOne
    @JoinColumn(name = "numprocesso")
    private Processo processo;
}
