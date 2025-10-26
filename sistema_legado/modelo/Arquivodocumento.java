package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the arquivodocumentos database table.
 * 
 */
@Entity
@Table(name="arquivodocumentos")
@NamedQuery(name="Arquivodocumento.findAll", query="SELECT a FROM Arquivodocumento a")
public class Arquivodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="arquivodocumentos_idarquivo", sequenceName = "arquivodocumentos_idarquivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="arquivodocumentos_idarquivo")
	private Integer idarquivo;

	@Temporal(TemporalType.DATE)
	private Date dataarquivo;

	private Time horaarquivo;

	private String nomearquivo;
	
	private String tamanhoarquivo;
	
	private String usuarioarquivo;
	
	private String tipoarquivo;
	
	private String nomeoriginal;
	
	private Integer statusarquivo;
	
	private String textoarquivo;
	
	private String nomeeditado;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;

	public Arquivodocumento() {
	}

	public Integer getIdarquivo() {
		return this.idarquivo;
	}

	public void setIdarquivo(Integer idarquivo) {
		this.idarquivo = idarquivo;
	}

	public Date getDataarquivo() {
		return this.dataarquivo;
	}

	public void setDataarquivo(Date dataarquivo) {
		this.dataarquivo = dataarquivo;
	}

	public Time getHoraarquivo() {
		return this.horaarquivo;
	}

	public void setHoraarquivo(Time horaarquivo) {
		this.horaarquivo = horaarquivo;
	}

	public String getNomearquivo() {
		return this.nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public String getTamanhoarquivo() {
		return tamanhoarquivo;
	}

	public void setTamanhoarquivo(String tamanhoarquivo) {
		this.tamanhoarquivo = tamanhoarquivo;
	}

	public String getUsuarioarquivo() {
		return usuarioarquivo;
	}

	public void setUsuarioarquivo(String usuarioarquivo) {
		this.usuarioarquivo = usuarioarquivo;
	}

	public String getTipoarquivo() {
		return tipoarquivo;
	}

	public void setTipoarquivo(String tipoarquivo) {
		this.tipoarquivo = tipoarquivo;
	}

	public String getNomeoriginal() {
		return nomeoriginal;
	}

	public void setNomeoriginal(String nomeoriginal) {
		this.nomeoriginal = nomeoriginal;
	}

	public Integer getStatusarquivo() {
		return statusarquivo;
	}

	public void setStatusarquivo(Integer statusarquivo) {
		this.statusarquivo = statusarquivo;
	}

	public String getTextoarquivo() {
		return textoarquivo;
	}

	public void setTextoarquivo(String textoarquivo) {
		this.textoarquivo = textoarquivo;
	}

	public String getNomeeditado() {
		return nomeeditado;
	}

	public void setNomeeditado(String nomeeditado) {
		this.nomeeditado = nomeeditado;
	}
	
	

}