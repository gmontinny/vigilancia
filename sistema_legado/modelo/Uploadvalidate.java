package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the uploadvalidate database table.
 * 
 */
@Entity
@NamedQuery(name="Uploadvalidate.findAll", query="SELECT u FROM Uploadvalidate u")
public class Uploadvalidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="uploadvalidate_iduploadvalidate", sequenceName = "uploadvalidate_iduploadvalidate_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="uploadvalidate_iduploadvalidate")
	private Integer iduploadvalidate;

	@Temporal(TemporalType.DATE)
	private Date dataupload;

	private String documentoupload;

	private Time horaupload;

	private Integer iddocnecessario;

	private String numprocesso;

	private Integer situacaoupload;

	private String textoupload;

	private Integer validacaoupload;

	public Uploadvalidate() {
	}

	public Integer getIduploadvalidate() {
		return this.iduploadvalidate;
	}

	public void setIduploadvalidate(Integer iduploadvalidate) {
		this.iduploadvalidate = iduploadvalidate;
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

	public Integer getIddocnecessario() {
		return this.iddocnecessario;
	}

	public void setIddocnecessario(Integer iddocnecessario) {
		this.iddocnecessario = iddocnecessario;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Integer getSituacaoupload() {
		return this.situacaoupload;
	}

	public void setSituacaoupload(Integer situacaoupload) {
		this.situacaoupload = situacaoupload;
	}

	public String getTextoupload() {
		return this.textoupload;
	}

	public void setTextoupload(String textoupload) {
		this.textoupload = textoupload;
	}

	public Integer getValidacaoupload() {
		return this.validacaoupload;
	}

	public void setValidacaoupload(Integer validacaoupload) {
		this.validacaoupload = validacaoupload;
	}

}