package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Column;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @SequenceGenerator(name = "servicos_idservicos_seq", sequenceName = "servicos_idservicos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicos_idservicos_seq")
    private Integer id;

    private Integer albergue;
    private Integer atividadesSomato;
    private Integer atividadeVeterinaria;
    private Integer dependenciaQuimica;
    private Integer esterilizacao;
    private Integer estetica;

    @Column(name = "grupo_a")
    private Integer grupoA;

    @Column(name = "grupo_b")
    private Integer grupoB;

    @Column(name = "grupo_c")
    private Integer grupoC;

    @Column(name = "grupo_d")
    private Integer grupoD;

    @Column(name = "grupo_e")
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

    @ManyToOne
    @JoinColumn(name = "numprocesso")
    private Processo processo;
}
