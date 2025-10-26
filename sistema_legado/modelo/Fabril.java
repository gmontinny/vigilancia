package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import br.com.caelum.stella.bean.validation.CNPJ;


/**
 * The persistent class for the fabril database table.
 * 
 */
@Entity
@NamedQuery(name="Fabril.findAll", query="SELECT f FROM Fabril f ORDER BY f.razaosocial")
public class Fabril implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="fabril_idfabril", sequenceName = "fabril_idfabril_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="fabril_idfabril")
	private Integer idfabril;
	
	@NotNull(message="BAIRRO campo Obrigatorio !")
	private String bairrofabril;
	
	@NotNull(message="CEP campo Obrigatorio !")
	private String cepfabril;

	@NotNull(message="CNPJ campo Obrigatorio !")
	@CNPJ(message="CNPJ invalido!")
	private String cnpjfabril;

	@NotNull(message="EMAIL campo Obrigatorio !")
	@Email(message="Email invalido !")
	private String emailfabril;

	private String fonefabril;

	@NotNull(message="MUNICÍPIO campo Obrigatorio !")
	private String municipiofabril;

	private Integer numerofabril;

	@NotNull(message="RAZÃO SOCIAL campo Obrigatorio !")
	private String razaosocial;

	@NotNull(message="RUA campo Obrigatorio !")
	private String ruafabril;

	@NotNull(message="TIPO FABRIL campo Obrigatorio !")
	private Integer tipofabril;

	@NotNull(message="UF campo Obrigatorio !")
	private String uffabril;

	public Fabril() {
	}

	public Integer getIdfabril() {
		return this.idfabril;
	}

	public void setIdfabril(Integer idfabril) {
		this.idfabril = idfabril;
	}

	public String getBairrofabril() {
		return this.bairrofabril;
	}

	public void setBairrofabril(String bairrofabril) {
		this.bairrofabril = bairrofabril;
	}

	public String getCepfabril() {
		return this.cepfabril;
	}

	public void setCepfabril(String cepfabril) {
		this.cepfabril = cepfabril;
	}

	public String getCnpjfabril() {
		return this.cnpjfabril;
	}

	public void setCnpjfabril(String cnpjfabril) {
		this.cnpjfabril = cnpjfabril;
	}

	public String getEmailfabril() {
		return this.emailfabril;
	}

	public void setEmailfabril(String emailfabril) {
		this.emailfabril = emailfabril;
	}

	public String getFonefabril() {
		return this.fonefabril;
	}

	public void setFonefabril(String fonefabril) {
		this.fonefabril = fonefabril;
	}

	public String getMunicipiofabril() {
		return this.municipiofabril;
	}

	public void setMunicipiofabril(String municipiofabril) {
		this.municipiofabril = municipiofabril;
	}

	public Integer getNumerofabril() {
		return this.numerofabril;
	}

	public void setNumerofabril(Integer numerofabril) {
		this.numerofabril = numerofabril;
	}

	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getRuafabril() {
		return this.ruafabril;
	}

	public void setRuafabril(String ruafabril) {
		this.ruafabril = ruafabril;
	}

	public Integer getTipofabril() {
		return this.tipofabril;
	}

	public void setTipofabril(Integer tipofabril) {
		this.tipofabril = tipofabril;
	}

	public String getUffabril() {
		return this.uffabril;
	}

	public void setUffabril(String uffabril) {
		this.uffabril = uffabril;
	}

}