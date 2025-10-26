package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class OrdemServicoDTO {
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
    private Integer idAcao;
    private String numeroProcesso;
}
