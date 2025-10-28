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
 * The persistent class for the balancomedicamento database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Balancomedicamento.findAll", query="SELECT b FROM Balancomedicamento b")
public class Balancomedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="balanco_idbalanco", sequenceName = "balanco_idbalanco_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="balanco_idbalanco")
	private Integer idbalanco;

	private Integer bmpoanual;

	private Integer bmpotrimestral;

	private Integer bspoanual;

	private Integer bspotrimestral;

	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de entrega campo Obrigatorio !")
	private Date dataentrega;

	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estabelecimento é Obrigatorio para Balanço Medicamento !")
	private Estabelecimento estabelecimento;

	private Integer livroreceituario;
	
	@NotNull(message="Mês de Referência campo Obrigatorio !")
	private Integer mesreferencia;

	private Integer qtdareceitaa;

	private Integer qtdareceitab;

	private Integer rmnramensal;

	private Integer rmnrb2mensal;

	private Integer rmvmensal;

	private Integer statusbalanco;

	private String textobalanco;

	private Integer trimestrebmpo;

	private Integer trimestrebspo;
	
	private Integer idusuario;
	
	private Integer balancoanual;
	
	@NotNull(message="Nome entregador é campo Obrigatorio !")
	private String entregador;

}