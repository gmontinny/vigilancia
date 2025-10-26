package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


/**
 * The persistent class for the reclamacao database table.
 * 
 */
@Entity
@NamedQuery(name="Reclamacao.findAll", query="SELECT r FROM Reclamacao r WHERE r.ordemservico.situacaoordemservico = 1 ORDER BY r.datareclamado DESC ")
public class Reclamacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="reclamacao_idreclamacao", sequenceName = "reclamacao_idreclamacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="reclamacao_idreclamacao")
	private Integer idreclamacao;
	
	private String bairroreclamado;

	@Temporal(TemporalType.DATE)
	private Date datareclamado;

	private String descricaoreclamado;
	
	private String enderecoreclamado;

	private String nomereclamado;
	
	private String nomereclamante;

	private String telefonereclamacao;

	private String tipoatendimento;

	private String tiporeclamado;
	
	private String pontoreferencia;
	
	private Integer anonimareclamacao;
	
	private Integer tipoimovel;
	
	private Time horareclamacao;
	
	
	//bi-directional many-to-one association to Ordemservico
	@ManyToOne
	@JoinColumn(name="idordemservico")
	private Ordemservico ordemservico;

	//bi-directional many-to-one association to Produtocategoria
	@ManyToOne
	@JoinColumn(name="idprodutocategoria")
	@NotNull(message="Produto Categoria campo obrigatorio !")
	private Produtocategoria produtocategoria;

	public Reclamacao() {
	}

	public Integer getIdreclamacao() {
		return this.idreclamacao;
	}

	public void setIdreclamacao(Integer idreclamacao) {
		this.idreclamacao = idreclamacao;
	}

	public String getBairroreclamado() {
		return this.bairroreclamado;
	}

	public void setBairroreclamado(String bairroreclamado) {
		this.bairroreclamado = bairroreclamado;
	}

	public Date getDatareclamado() {
		return this.datareclamado;
	}

	public void setDatareclamado(Date datareclamado) {
		this.datareclamado = datareclamado;
	}

	public String getDescricaoreclamado() {
		return this.descricaoreclamado;
	}

	public void setDescricaoreclamado(String descricaoreclamado) {
		this.descricaoreclamado = descricaoreclamado;
	}

	public String getEnderecoreclamado() {
		return this.enderecoreclamado;
	}

	public void setEnderecoreclamado(String enderecoreclamado) {
		this.enderecoreclamado = enderecoreclamado;
	}


	public String getNomereclamado() {
		return this.nomereclamado;
	}

	public void setNomereclamado(String nomereclamado) {
		this.nomereclamado = nomereclamado;
	}

	public String getTelefonereclamacao() {
		return this.telefonereclamacao;
	}

	public void setTelefonereclamacao(String telefonereclamacao) {
		this.telefonereclamacao = telefonereclamacao;
	}

	public String getTipoatendimento() {
		return this.tipoatendimento;
	}

	public void setTipoatendimento(String tipoatendimento) {
		this.tipoatendimento = tipoatendimento;
	}

	public String getTiporeclamado() {
		return this.tiporeclamado;
	}

	public void setTiporeclamado(String tiporeclamado) {
		this.tiporeclamado = tiporeclamado;
	}

	public Ordemservico getOrdemservico() {
		return this.ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}

	public Produtocategoria getProdutocategoria() {
		return this.produtocategoria;
	}

	public void setProdutocategoria(Produtocategoria produtocategoria) {
		this.produtocategoria = produtocategoria;
	}

	public String getPontoreferencia() {
		return pontoreferencia;
	}

	public void setPontoreferencia(String pontoreferencia) {
		this.pontoreferencia = pontoreferencia;
	}

	public String getNomereclamante() {
		return nomereclamante;
	}

	public void setNomereclamante(String nomereclamante) {
		this.nomereclamante = nomereclamante;
	}

	public Integer getAnonimareclamacao() {
		return anonimareclamacao;
	}

	public void setAnonimareclamacao(Integer anonimareclamacao) {
		this.anonimareclamacao = anonimareclamacao;
	}

	public Integer getTipoimovel() {
		return tipoimovel;
	}

	public void setTipoimovel(Integer tipoimovel) {
		this.tipoimovel = tipoimovel;
	}

	public Time getHorareclamacao() {
		return horareclamacao;
	}

	public void setHorareclamacao(Time horareclamacao) {
		this.horareclamacao = horareclamacao;
	}


	
}