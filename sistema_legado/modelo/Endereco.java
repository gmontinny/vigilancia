package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="endereco_idendereco", sequenceName = "endereco_idendereco_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="endereco_idendereco")
	private Integer idendereco;
	
	@NotNull(message="Bairro campo obrigatorio !")
	@Size(min=3, message="Digite no minimo 3 caracteres para Bairro!")
	private String bairroendereco;
	
	@NotNull(message="CEP campo obrigatorio !")
	private String cependereco;

	private String complementoendereco;

	private String logradouroendereco;

	private Integer numeroendereco;
	
	private String longitudeendereco;
	
	private String latitudeendereco;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")	
	private Usuario usuario;

	
	public Endereco(String bairroendereco, String cependereco, String complementoendereco, String logradouroendereco,
			Integer numeroendereco, String latitudeendereco, String longitudeendereco ) {
	
		this.bairroendereco = bairroendereco;
		this.cependereco = cependereco;
		this.complementoendereco = complementoendereco;
		this.logradouroendereco = logradouroendereco;
		this.numeroendereco = numeroendereco;
		this.latitudeendereco = latitudeendereco;
		this.longitudeendereco = longitudeendereco;
		
	}

	public Endereco() {
	}

	public Integer getIdendereco() {
		return this.idendereco;
	}

	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}

	public String getBairroendereco() {
		return this.bairroendereco;
	}

	public void setBairroendereco(String bairroendereco) {
		this.bairroendereco = bairroendereco;
	}

	public String getCependereco() {
		return this.cependereco;
	}

	public void setCependereco(String cependereco) {
		this.cependereco = cependereco;
	}

	public String getComplementoendereco() {
		return this.complementoendereco;
	}

	public void setComplementoendereco(String complementoendereco) {
		this.complementoendereco = complementoendereco;
	}

	public String getLogradouroendereco() {
		return this.logradouroendereco;
	}

	public void setLogradouroendereco(String logradouroendereco) {
		this.logradouroendereco = logradouroendereco;
	}

	public Integer getNumeroendereco() {
		return this.numeroendereco;
	}

	public void setNumeroendereco(Integer numeroendereco) {
		this.numeroendereco = numeroendereco;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLongitudeendereco() {
		return longitudeendereco;
	}

	public void setLongitudeendereco(String longitudeendereco) {
		this.longitudeendereco = longitudeendereco;
	}

	public String getLatitudeendereco() {
		return latitudeendereco;
	}

	public void setLatitudeendereco(String latitudeendereco) {
		this.latitudeendereco = latitudeendereco;
	}
	
	

}