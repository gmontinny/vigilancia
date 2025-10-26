package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the motivo database table.
 * 
 */
@Entity
@NamedQuery(name="Motivo.findAll", query="SELECT m FROM Motivo m")
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="motivo_idmotivo", sequenceName = "motivo_idmotivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="motivo_idmotivo")
	private Integer idmotivo;
	
	@NotNull(message="Campo obrigatorio !")
	@Size(min=5,message="Digite pelo menos 5 caracteres !")
	private String descricaomotivo;

	//bi-directional many-to-one association to Termocolheita
	@OneToMany(mappedBy="motivo")
	private List<Termocolheita> termocolheitas;

	public Motivo() {
	}

	public Integer getIdmotivo() {
		return this.idmotivo;
	}

	public void setIdmotivo(Integer idmotivo) {
		this.idmotivo = idmotivo;
	}

	public String getDescricaomotivo() {
		return this.descricaomotivo;
	}

	public void setDescricaomotivo(String descricaomotivo) {
		this.descricaomotivo = descricaomotivo;
	}

	public List<Termocolheita> getTermocolheitas() {
		return this.termocolheitas;
	}

	public void setTermocolheitas(List<Termocolheita> termocolheitas) {
		this.termocolheitas = termocolheitas;
	}

	public Termocolheita addTermocolheita(Termocolheita termocolheita) {
		getTermocolheitas().add(termocolheita);
		termocolheita.setMotivo(this);

		return termocolheita;
	}

	public Termocolheita removeTermocolheita(Termocolheita termocolheita) {
		getTermocolheitas().remove(termocolheita);
		termocolheita.setMotivo(null);

		return termocolheita;
	}

}