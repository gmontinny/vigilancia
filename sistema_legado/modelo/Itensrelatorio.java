package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itensrelatorio database table.
 * 
 */
@Entity
@NamedQuery(name="Itensrelatorio.findAll", query="SELECT i FROM Itensrelatorio i")
public class Itensrelatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensrelatorio_iditensrelatorio", sequenceName = "itensrelatorio_iditensrelatorio_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensrelatorio_iditensrelatorio")
	private Integer iditensrelatorio;

	//bi-directional many-to-one association to Relatorio
	@ManyToOne
	@JoinColumn(name="idrelatorio")
	private Relatorio relatorio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Itensrelatorio() {
	}

	public Integer getIditensrelatorio() {
		return this.iditensrelatorio;
	}

	public void setIditensrelatorio(Integer iditensrelatorio) {
		this.iditensrelatorio = iditensrelatorio;
	}

	public Relatorio getRelatorio() {
		return this.relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}