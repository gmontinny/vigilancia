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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @SequenceGenerator(name = "produtos_idprodutos_seq", sequenceName = "produtos_idprodutos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_idprodutos_seq")
    private Integer id;

    private Integer aditivoAlimento;
    private Integer agrotoxico;
    private Integer aguaMineral;
    private Integer aguaPotavel;
    private Integer alimentosAutorizados;
    private Integer alimentosProntos;
    private Integer armazenar;
    private Integer comercializar;
    private Integer cosmeticos;
    private Integer dispensadorRegistro;
    private Integer dispensar;
    private Integer distribuir;
    private Integer embalagemAlimento;
    private Integer embalar;
    private Integer exportar;
    private Integer fracionar;
    private Integer grupo1;
    private Integer grupo2;
    private Integer grupo3;
    private Integer grupo5;
    private Integer higiene;
    private Integer importar;
    private Integer manipular;
    private Integer medicamentoNaoEspecial;
    private Integer medicamentosEspecial;
    private Integer oleoVegetal;
    private Integer outros;
    private String outroMesmoProduto;
    private Integer perfumaria;
    private Integer produzir;
    private Integer quimicos;
    private Integer reembalar;
    private Integer retinoicos;
    private Integer saneantes;
    private Integer saude;
    private Integer suplementos;
    private Integer transportar;
    private Integer tratar;
    private Integer veterinario;
    private Integer deferidoFiscal;
    private Integer outrosCasos;

    @ManyToOne
    @JoinColumn(name = "numprocesso")
    private Processo processo;
}
