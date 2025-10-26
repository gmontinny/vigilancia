package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.CPF;


/**
 * The persistent class for the gestaodocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Gestaodocumento.findAll", query="SELECT g FROM Gestaodocumento g WHERE g.status <> 5 ORDER BY g.idgestaodocumento DESC ")
public class Gestaodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="gestaodocumento_idgestaodocumento", sequenceName = "gestaodocumento_idgestaodocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="gestaodocumento_idgestaodocumento")
	private Integer idgestaodocumento;

	@NotNull(message="Assunto campo Obrigatorio !")
	private String assuntogestaodocumento;

	@NotNull(message="CPF campo Obrigatorio !")
	@CPF(message="CPF invalido !")
	private String cpfentregador;

	private Integer numerodocumento;
	
	@NotNull(message="NOME entregador campo Obrigatorio !")
	private String nomeentregador;

	@NotNull(message="Solicitante campo Obrigatorio !")
	private String solicitantegestaodocumento;
	
	@NotNull(message="Tipo Solicitação campo Obrigatorio !")
	private Integer tiposolicitacao;
	
	@Temporal(TemporalType.DATE)
	private Date datagestaodocumento;	
	
	private Integer idusuario;
	private String numprocesso;
	private Integer status;
	private String textodocumento;
	
	private Integer idusuariodestino;
	
	private Integer statusenvio;
	
	private Time horagestaodocumento;
	
	private Integer notificacao;
	
	private String usuariosnotificacao;
	

	public Gestaodocumento() {
	}

	public Integer getIdgestaodocumento() {
		return this.idgestaodocumento;
	}

	public void setIdgestaodocumento(Integer idgestaodocumento) {
		this.idgestaodocumento = idgestaodocumento;
	}

	public String getAssuntogestaodocumento() {
		return this.assuntogestaodocumento;
	}

	public void setAssuntogestaodocumento(String assuntogestaodocumento) {
		this.assuntogestaodocumento = assuntogestaodocumento;
	}

	public String getCpfentregador() {
		return this.cpfentregador;
	}

	public void setCpfentregador(String cpfentregador) {
		this.cpfentregador = cpfentregador;
	}

	public Integer getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(Integer numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getNomeentregador() {
		return nomeentregador;
	}

	public void setNomeentregador(String nomeentregador) {
		this.nomeentregador = nomeentregador;
	}

	public String getSolicitantegestaodocumento() {
		return this.solicitantegestaodocumento;
	}

	public void setSolicitantegestaodocumento(String solicitantegestaodocumento) {
		this.solicitantegestaodocumento = solicitantegestaodocumento;
	}

	public Date getDatagestaodocumento() {
		return datagestaodocumento;
	}

	public void setDatagestaodocumento(Date datagestaodocumento) {
		this.datagestaodocumento = datagestaodocumento;
	}

	public Time getHoragestaodocumento() {
		return horagestaodocumento;
	}

	public void setHoragestaodocumento(Time horagestaodocumento) {
		this.horagestaodocumento = horagestaodocumento;
	}

	public Integer getTiposolicitacao() {
		return tiposolicitacao;
	}

	public void setTiposolicitacao(Integer tiposolicitacao) {
		this.tiposolicitacao = tiposolicitacao;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNumprocesso() {
		return numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTextodocumento() {
		return textodocumento;
	}

	public void setTextodocumento(String textodocumento) {
		this.textodocumento = textodocumento;
	}

	public Integer getIdusuariodestino() {
		return idusuariodestino;
	}

	public void setIdusuariodestino(Integer idusuariodestino) {
		this.idusuariodestino = idusuariodestino;
	}

	public Integer getStatusenvio() {
		return statusenvio;
	}

	public void setStatusenvio(Integer statusenvio) {
		this.statusenvio = statusenvio;
	}

	public Integer getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Integer notificacao) {
		this.notificacao = notificacao;
	}

	public String getUsuariosnotificacao() {
		return usuariosnotificacao;
	}

	public void setUsuariosnotificacao(String usuariosnotificacao) {
		this.usuariosnotificacao = usuariosnotificacao;
	}

	
	
}