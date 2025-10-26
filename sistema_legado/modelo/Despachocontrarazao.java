package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the despachocontrarazao database table.
 * 
 */
@Entity
@NamedQuery(name="Despachocontrarazao.findAll", query="SELECT d FROM Despachocontrarazao d ORDER BY d.iddespachocontrarazao DESC")
public class Despachocontrarazao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachocontrarazao_iddespachocontrarazao", sequenceName = "despachocontrarazao_iddespachocontrarazao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachocontrarazao_iddespachocontrarazao")
	private Integer iddespachocontrarazao;
	
	@NotNull(message="Gerente é um campo necessario !")
	private String gerenteresponsavel;

	private String imagemassinatura;

	@NotNull(message="Texto é um  campo Necessário !")
	private String textodespacho;

	public Despachocontrarazao() {
	}

	public Integer getIddespachocontrarazao() {
		return this.iddespachocontrarazao;
	}

	public void setIddespachocontrarazao(Integer iddespachocontrarazao) {
		this.iddespachocontrarazao = iddespachocontrarazao;
	}

	public String getGerenteresponsavel() {
		return this.gerenteresponsavel;
	}

	public void setGerenteresponsavel(String gerenteresponsavel) {
		this.gerenteresponsavel = gerenteresponsavel;
	}

	public String getImagemassinatura() {
		return this.imagemassinatura;
	}

	public void setImagemassinatura(String imagemassinatura) {
		this.imagemassinatura = imagemassinatura;
	}

	public String getTextodespacho() {
		return this.textodespacho;
	}

	public void setTextodespacho(String textodespacho) {
		this.textodespacho = textodespacho;
	}

}