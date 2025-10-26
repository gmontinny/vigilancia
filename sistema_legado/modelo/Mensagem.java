package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the mensagem database table.
 * 
 */
@Entity
@NamedQuery(name="Mensagem.findAll", query="SELECT m FROM Mensagem m")
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="mensagem_idmensagem", sequenceName = "mensagem_idmensagem_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mensagem_idmensagem")
	private Integer idmensagem;

	@Temporal(TemporalType.DATE)
	private Date datamensagem;
	
	@NotNull(message="Usuario de Origem campo obrigatorio !")
	private String demensagem;
	
	@NotNull(message="Usuario de Destino campo obrigatorio !")
	private String paramensagem;

	private Integer statusmensagem;
	
	@NotNull(message="Campo texto obrigatorio !")
	private String textomensagem;
	
	private Integer idusuario;
		
	@ManyToOne
	@JoinColumn(name="idordemservico")
	@NotNull(message="Ordem Serviço Campo Obrigatorio!")
	private Ordemservico ordemservico;

	public Mensagem() {
	}

	public Integer getIdmensagem() {
		return this.idmensagem;
	}

	public void setIdmensagem(Integer idmensagem) {
		this.idmensagem = idmensagem;
	}

	public Date getDatamensagem() {
		return this.datamensagem;
	}

	public void setDatamensagem(Date datamensagem) {
		this.datamensagem = datamensagem;
	}

	public String getDemensagem() {
		return this.demensagem;
	}

	public void setDemensagem(String demensagem) {
		this.demensagem = demensagem;
	}

	public String getParamensagem() {
		return this.paramensagem;
	}

	public void setParamensagem(String paramensagem) {
		this.paramensagem = paramensagem;
	}

	public Integer getStatusmensagem() {
		return this.statusmensagem;
	}

	public void setStatusmensagem(Integer statusmensagem) {
		this.statusmensagem = statusmensagem;
	}

	public String getTextomensagem() {
		return this.textomensagem;
	}

	public void setTextomensagem(String textomensagem) {
		this.textomensagem = textomensagem;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Ordemservico getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}
	
	

}