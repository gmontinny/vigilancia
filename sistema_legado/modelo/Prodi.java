package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.caelum.stella.bean.validation.CNPJ;


/**
 * The persistent class for the prodi database table.
 * 
 */
@Entity
@NamedQuery(name="Prodi.findAll", query="SELECT p FROM Prodi p")
public class Prodi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="prodi_idprodi", sequenceName = "prodi_idprodi_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="prodi_idprodi")
	private Integer idprodi;
	
	@NotNull(message="CNPJ da Empresa campo Obrigatorio !")
	@CNPJ(message="CNPJ Invalido !")
	private String cnpjempresa;
	
	@NotNull(message="CNPJ do Fabricante campo Obrigatorio !")
	@CNPJ(message="CNPJ Invalido !")
	private String cnpjfabricante;
	
	private String numeroprocesso;

	private Integer numeroprodi;

	public Prodi() {
	}

	public Integer getIdprodi() {
		return this.idprodi;
	}

	public void setIdprodi(Integer idprodi) {
		this.idprodi = idprodi;
	}

	public String getCnpjempresa() {
		return this.cnpjempresa;
	}

	public void setCnpjempresa(String cnpjempresa) {
		this.cnpjempresa = cnpjempresa;
	}

	public String getCnpjfabricante() {
		return this.cnpjfabricante;
	}

	public void setCnpjfabricante(String cnpjfabricante) {
		this.cnpjfabricante = cnpjfabricante;
	}

	public String getNumeroprocesso() {
		return this.numeroprocesso;
	}

	public void setNumeroprocesso(String numeroprocesso) {
		this.numeroprocesso = numeroprocesso;
	}

	public Integer getNumeroprodi() {
		return this.numeroprodi;
	}

	public void setNumeroprodi(Integer numeroprodi) {
		this.numeroprodi = numeroprodi;
	}

}