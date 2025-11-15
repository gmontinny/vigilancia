package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaorecursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idnotificacaorecurso;
    private String assinaturacoordenador;
    private String coordenadorarecursonotificacao;
    private String textonotificacaorecurso;
}
