package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the geracategoriaservico database table.
 * 
 */
@Entity
@NamedQuery(name="Geracategoriaservico.findAll", query=" SELECT g FROM Geracategoriaservico g ORDER BY g.idgeracategoriaservico DESC ")
public class Geracategoriaservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geracategoriaservico_idgeracategoriaservico", sequenceName = "geracategoriaservico_idgeracategoriaservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geracategoriaservico_idgeracategoriaservico")
	private Integer idgeracategoriaservico;

	@Temporal(TemporalType.DATE)
	private Date datacategoriaservico;

	private Integer idusuario;

	private Integer status;

	public Geracategoriaservico() {
	}

	public Integer getIdgeracategoriaservico() {
		return this.idgeracategoriaservico;
	}

	public void setIdgeracategoriaservico(Integer idgeracategoriaservico) {
		this.idgeracategoriaservico = idgeracategoriaservico;
	}

	public Date getDatacategoriaservico() {
		return this.datacategoriaservico;
	}

	public void setDatacategoriaservico(Date datacategoriaservico) {
		this.datacategoriaservico = datacategoriaservico;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}