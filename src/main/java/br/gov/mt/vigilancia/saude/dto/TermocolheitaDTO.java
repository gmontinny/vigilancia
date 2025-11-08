package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermocolheitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idtermocolheita;
    private String apresentacaotermocolheita;
    private String bairrotermocolheita;
    private String ceptermocolheita;
    private String cidadetermocolheita;
    private String cnpjtermocolheita;
    private Integer contraprova01;
    private Integer contraprova02;
    private Integer contraprova03;
    private String embaladortermocolheita;
    private String enderecotermocolheita;
    private String fabricantetermocolheita;
    private Integer finsanalisetermocolheita;
    private Integer numerotramitacao;
    private String nomeproduto;
    private Date datacolheita;
    private Integer idprodutocategoria;
    private String inscricaotermocolheita;
    private Integer laboratorio01;
    private Integer laboratorio02;
    private Integer laboratorio03;
    private Integer lacre01termocolheita;
    private Integer lacre02termocolheita;
    private Integer lacre03termocolheita;
    private String localconsumo;
    private String lotetermocolheita;
    private String marcatermocolheita;
    private Integer numeroconsumidor;
    private String observacao;
    private String periodoincubacao;
    private String pesovolumento;
    private Integer quantidadeamostra;
    private Integer quantidadedoente;
    private String registrotermocolheita;
    private String tecnicoresponsavel;
    private String termometrotermocolheita;
    private String tipoanalise;
    private String uftermocolheita;
    private String validadetermocolheita;
    private String fabricacaotermocolheita;
    private Integer idmotivo;
    private Integer numeroendereco;
    private String sintomastermocolheita;
    private String telefonetermocolheita;
    private String arquivolaudo;
    private Integer tipoformatacao;
}
