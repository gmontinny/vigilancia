package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ReclamacaoDTO {
    private Integer id;
    private String bairroReclamado;
    private LocalDate dataReclamado;
    private String descricaoReclamado;
    private String enderecoReclamado;
    private String nomeReclamado;
    private String nomeReclamante;
    private String telefoneReclamacao;
    private String tipoAtendimento;
    private String tipoReclamado;
    private String pontoReferencia;
    private Integer anonimaReclamacao;
    private Integer tipoImovel;
    private LocalTime horaReclamacao;
    private Integer idOrdemServico;
    private Integer idProdutoCategoria;
}
