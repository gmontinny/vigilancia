package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the conselho database table.
 * 
 */
@Entity
@NamedQuery(name="Conselho.findAll", query="SELECT c FROM Conselho c ORDER BY c.nomeconselho")
public class Conselho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="conselho_idconselho", sequenceName = "conselho_idconselho_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="conselho_idconselho")
	private Integer idconselho;
	
	@NotNull(message="Nome campo Obrigatorio !")
	@Size(min=5,message="Digite no minimo 3 caracteres !")
	private String nomeconselho;

	//bi-directional many-to-one association to Responsaveltecnico
	@OneToMany(mappedBy="conselho")
	private List<Responsaveltecnico> responsaveltecnicos;


	public Integer getIdconselho() {
		return this.idconselho;
	}

	public void setIdconselho(Integer idconselho) {
		this.idconselho = idconselho;
	}

	public String getNomeconselho() {
		return this.nomeconselho;
	}

	public void setNomeconselho(String nomeconselho) {
		this.nomeconselho = nomeconselho;
	}

	public List<Responsaveltecnico> getResponsaveltecnicos() {
		return this.responsaveltecnicos;
	}

	public void setResponsaveltecnicos(List<Responsaveltecnico> responsaveltecnicos) {
		this.responsaveltecnicos = responsaveltecnicos;
	}

	public Responsaveltecnico addResponsaveltecnico(Responsaveltecnico responsaveltecnico) {
		getResponsaveltecnicos().add(responsaveltecnico);
		responsaveltecnico.setConselho(this);

		return responsaveltecnico;
	}

	public Responsaveltecnico removeResponsaveltecnico(Responsaveltecnico responsaveltecnico) {
		getResponsaveltecnicos().remove(responsaveltecnico);
		responsaveltecnico.setConselho(null);

		return responsaveltecnico;
	}

}