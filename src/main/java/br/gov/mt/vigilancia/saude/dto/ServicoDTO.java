package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoDTO {
    private Integer id;
    private Integer albergue;
    private Integer atividadesSomato;
    private Integer atividadeVeterinaria;
    private Integer dependenciaQuimica;
    private Integer esterilizacao;
    private Integer estetica;
    private Integer grupoA;
    private Integer grupoB;
    private Integer grupoC;
    private Integer grupoD;
    private Integer grupoE;
    private Integer idoso;
    private Integer industrial;
    private Integer laboratorio;
    private Integer lavanderiaDomestica;
    private Integer lavanderia;
    private Integer limpaFossa;
    private Integer limpezaArCondicionado;
    private Integer limpezaCaixaDagua;
    private Integer limpeza;
    private Integer medicinaTrabalho;
    private Integer pipa;
    private Integer pragas;
    private Integer saa;
    private Integer salaoBeleza;
    private Integer tatuagem;
    private String numeroProcesso;
}
