package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the tabela database table.
 * 
 */
@Entity
@NamedQuery(name="Tabela.findAll", query="SELECT t FROM Tabela t")
public class Tabela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tabela_idtabelas", sequenceName = "tabela_idtabelas_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tabela_idtabelas")
	private Integer idtabelas;
	
	@NotNull(message="Descrição campo Obrigratorio!")	
	private String descricaotabela;
	
	@NotNull(message="Nome campo Obrigratorio!")
	private String nometabela;
	
	@NotNull(message="Tipo campo Obrigratorio!")
	private Integer ordemtabela;

	//bi-directional many-to-one association to Permissao
	@OneToMany(mappedBy="tabela")
	private List<Permissao> permissaos;

	public Tabela() {
	}

	public Integer getIdtabelas() {
		return this.idtabelas;
	}

	public void setIdtabelas(Integer idtabelas) {
		this.idtabelas = idtabelas;
	}

	public String getDescricaotabela() {
		return this.descricaotabela;
	}

	public void setDescricaotabela(String descricaotabela) {
		this.descricaotabela = descricaotabela;
	}

	public String getNometabela() {
		return this.nometabela;
	}

	public void setNometabela(String nometabela) {
		this.nometabela = nometabela;
	}

	public Integer getOrdemtabela() {
		return this.ordemtabela;
	}

	public void setOrdemtabela(Integer ordemtabela) {
		this.ordemtabela = ordemtabela;
	}

	public List<Permissao> getPermissaos() {
		return this.permissaos;
	}

	public void setPermissaos(List<Permissao> permissaos) {
		this.permissaos = permissaos;
	}

	public Permissao addPermissao(Permissao permissao) {
		getPermissaos().add(permissao);
		permissao.setTabela(this);

		return permissao;
	}

	public Permissao removePermissao(Permissao permissao) {
		getPermissaos().remove(permissao);
		permissao.setTabela(null);

		return permissao;
	}

}