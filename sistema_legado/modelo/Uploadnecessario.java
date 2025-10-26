package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the uploadnecessario database table.
 * 
 */
@Entity
@NamedQuery(name="Uploadnecessario.findAll", query="SELECT u FROM Uploadnecessario u")
public class Uploadnecessario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="uploadnecessario_iduploadnecessario", sequenceName = "uploadnecessario_iduploadnecessario_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="uploadnecessario_iduploadnecessario")
	private Integer iduploadnecessario;

	@Temporal(TemporalType.DATE)
	private Date dataupload;

	private String documentoupload;

	private Time horaupload;

	@ManyToOne
	@JoinColumn(name = "iddocnecessario")
	private Docnecessario docnecessario;

	private String numprocesso;

	private Integer validacaoupload;
	
	private Integer situacaoupload;
	
	private String textoupload;

	public Uploadnecessario() {
	}

	public Integer getIduploadnecessario() {
		return this.iduploadnecessario;
	}

	public void setIduploadnecessario(Integer iduploadnecessario) {
		this.iduploadnecessario = iduploadnecessario;
	}

	public Date getDataupload() {
		return this.dataupload;
	}

	public void setDataupload(Date dataupload) {
		this.dataupload = dataupload;
	}

	public String getDocumentoupload() {
		return this.documentoupload;
	}

	public void setDocumentoupload(String documentoupload) {
		this.documentoupload = documentoupload;
	}

	public Time getHoraupload() {
		return this.horaupload;
	}

	public void setHoraupload(Time horaupload) {
		this.horaupload = horaupload;
	}

	public Docnecessario getDocnecessario() {
		return docnecessario;
	}

	public void setDocnecessario(Docnecessario docnecessario) {
		this.docnecessario = docnecessario;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Integer getValidacaoupload() {
		return this.validacaoupload;
	}

	public void setValidacaoupload(Integer validacaoupload) {
		this.validacaoupload = validacaoupload;
	}

	public Integer getSituacaoupload() {
		return situacaoupload;
	}

	public void setSituacaoupload(Integer situacaoupload) {
		this.situacaoupload = situacaoupload;
	}

	public String getTextoupload() {
		return textoupload;
	}

	public void setTextoupload(String textoupload) {
		this.textoupload = textoupload;
	}
	
	

}