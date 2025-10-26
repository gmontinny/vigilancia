package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the servicosaude database table.
 * 
 */
@Entity
@NamedQuery(name="Servicosaude.findAll", query="SELECT s FROM Servicosaude s ORDER BY s.idservicosaude")
public class Servicosaude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="servicosaude_idservicosaude", sequenceName = "servicosaude_idservicosaude_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="servicosaude_idservicosaude")
	private Integer idservicosaude;
	
	@ManyToOne
	@JoinColumn(name="idagrupamento")
	private Agrupamento agrupamento;

	@NotNull(message="N° SERVIÇO campo Obrigatorio !")
	private Integer numeroservico;

	//bi-directional many-to-one association to Categoriaservico
	@ManyToOne
	@JoinColumn(name="idcategoriaservico")
	private Categoriaservico categoriaservico;
	
	private Integer idcategoriaanalise;

	public Servicosaude() {
	}

	public Integer getIdservicosaude() {
		return this.idservicosaude;
	}

	public void setIdservicosaude(Integer idservicosaude) {
		this.idservicosaude = idservicosaude;
	}
	
	public Agrupamento getAgrupamento() {
		return agrupamento;
	}

	public void setAgrupamento(Agrupamento agrupamento) {
		this.agrupamento = agrupamento;
	}

	public Integer getNumeroservico() {
		return this.numeroservico;
	}

	public void setNumeroservico(Integer numeroservico) {
		this.numeroservico = numeroservico;
	}

	public Categoriaservico getCategoriaservico() {
		return this.categoriaservico;
	}

	public void setCategoriaservico(Categoriaservico categoriaservico) {
		this.categoriaservico = categoriaservico;
	}

	public Integer getIdcategoriaanalise() {
		return idcategoriaanalise;
	}

	public void setIdcategoriaanalise(Integer idcategoriaanalise) {
		this.idcategoriaanalise = idcategoriaanalise;
	}
	
	

}