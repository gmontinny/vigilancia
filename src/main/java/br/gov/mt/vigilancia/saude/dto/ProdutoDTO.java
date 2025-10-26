package br.gov.mt.vigilancia.saude.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {
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
    private String numeroProcesso;
}
