package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the restricao database table.
 * 
 */
@Entity
@NamedQuery(name="Restricao.findAll", query="SELECT r FROM Restricao r")
public class Restricao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="restricao_idrestricao", sequenceName = "restricao_idrestricao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="restricao_idrestricao")
	private Integer idrestricao;

	@Temporal(TemporalType.DATE)
	private Date datarestricao;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	private Integer statusrestricao;

	private String textorestricao;

	public Restricao() {
	}

	public Integer getIdrestricao() {
		return this.idrestricao;
	}

	public void setIdrestricao(Integer idrestricao) {
		this.idrestricao = idrestricao;
	}

	public Date getDatarestricao() {
		return this.datarestricao;
	}

	public void setDatarestricao(Date datarestricao) {
		this.datarestricao = datarestricao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getStatusrestricao() {
		return this.statusrestricao;
	}

	public void setStatusrestricao(Integer statusrestricao) {
		this.statusrestricao = statusrestricao;
	}

	public String getTextorestricao() {
		return this.textorestricao;
	}

	public void setTextorestricao(String textorestricao) {
		this.textorestricao = textorestricao;
	}

}