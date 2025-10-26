package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the documentoerrado database table.
 * 
 */
@Entity
@NamedQuery(name="Documentoerrado.findAll", query="SELECT d FROM Documentoerrado d")
public class Documentoerrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="documentoerrado_iddocumentoerrado", sequenceName = "documentoerrado_iddocumentoerrado_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="documentoerrado_iddocumentoerrado")
	private Integer iddocumentoerrado;

	@Temporal(TemporalType.DATE)
	private Date datadocumentoerrado;

	private Time horadocumentoerrado;
	
	private String arquivodocumentoerrado;

	@ManyToOne
	@JoinColumn(name="iduploadnecessario")
	private Uploadnecessario uploadnecessario;

	public Documentoerrado() {
	}

	public Integer getIddocumentoerrado() {
		return this.iddocumentoerrado;
	}

	public void setIddocumentoerrado(Integer iddocumentoerrado) {
		this.iddocumentoerrado = iddocumentoerrado;
	}

	public Date getDatadocumentoerrado() {
		return this.datadocumentoerrado;
	}

	public void setDatadocumentoerrado(Date datadocumentoerrado) {
		this.datadocumentoerrado = datadocumentoerrado;
	}

	public Time getHoradocumentoerrado() {
		return this.horadocumentoerrado;
	}

	public void setHoradocumentoerrado(Time horadocumentoerrado) {
		this.horadocumentoerrado = horadocumentoerrado;
	}

	public Uploadnecessario getUploadnecessario() {
		return uploadnecessario;
	}

	public void setUploadnecessario(Uploadnecessario uploadnecessario) {
		this.uploadnecessario = uploadnecessario;
	}

	public String getArquivodocumentoerrado() {
		return arquivodocumentoerrado;
	}

	public void setArquivodocumentoerrado(String arquivodocumentoerrado) {
		this.arquivodocumentoerrado = arquivodocumentoerrado;
	}
	

}