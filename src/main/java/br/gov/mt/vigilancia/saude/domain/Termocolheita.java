package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the termocolheita database table.
 * 
 */
@Entity
@Table(name = "termocolheita", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Termocolheita.findAll", query="SELECT t FROM Termocolheita t")
public class Termocolheita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="termocolheita_idtermocolheita", sequenceName = "termocolheita_idtermocolheita_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="termocolheita_idtermocolheita")
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
	
	@Temporal(TemporalType.DATE)
	private Date datacolheita;
	
	@ManyToOne
	@JoinColumn(name="idprodutocategoria")
	private ProdutoCategoria produtocategoria;

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

	//bi-directional many-to-one association to Motivo
	@ManyToOne
	@JoinColumn(name="idmotivo")
	private Motivo motivo;
	
	private Integer numeroendereco;

	private String sintomastermocolheita;
	
	private String telefonetermocolheita;
	
	private String arquivolaudo;
	
	private Integer tipoformatacao;

}