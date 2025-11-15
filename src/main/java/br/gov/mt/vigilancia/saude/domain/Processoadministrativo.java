package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the processoadministrativo database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Processoadministrativo.findAll", query="SELECT p FROM Processoadministrativo p")
public class Processoadministrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="processoadministrativo_idprocessoadministrativo", sequenceName = "processoadministrativo_idprocessoadministrativo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="processoadministrativo_idprocessoadministrativo")
	private Integer idprocessoadministrativo;

	@Temporal(TemporalType.DATE)
	private Date dataprocesso;
	
	@Temporal(TemporalType.DATE)
	private Date dataciencia;
	
	private Integer indicadorcontrarazao;

	private Integer numeroauto;
	
	@ManyToOne
	@JoinColumn(name="numprocesso")
	@NotNull(message="Processo campo Obrigatorio !")
	private Processo processo;

	private String textorazao;

	private String textoresposta;
	
	private String processogerado;

	private Integer tiporesultado;
	
	private Integer fiscalresponsavel;
	
	private Integer fiscalcontraresposta;
	
	private Integer tiposituacao;

}