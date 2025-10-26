package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the estabelecimento database table.
 * 
 */
@Entity
@NamedQuery(name="Estabelecimento.findAll", query="SELECT e FROM Estabelecimento e ORDER BY e.idestabelecimento DESC ")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="estabelecimento_idestabelecimento", sequenceName = "estabelecimento_idestabelecimento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="estabelecimento_idestabelecimento")
	private Integer idestabelecimento;
	
	@NotNull(message="Area campo obrigatorio !")
	private String areaestabelecimento;
	
	@NotNull(message="Bairro campo obrigatorio !")	
	private String bairroestabelecimento;

	private String celularestabelecimento;
	
	@NotNull(message="CEP campo obrigatorio !")
	private String cepestabelecimento;
	
	private Long cmestabelecimento;

	private Long cnesestabelecimento;

	private String cnpjestabelecimento;

	private String cpfresponsavel;

	@Temporal(TemporalType.DATE)
	private Date datacadastro;
	
	@NotNull(message="EMAIL campo obrigatorio !")
	@Email(message="EMAIL invalido !")
	private String emailestabelecimento;
	
	@NotNull(message="Endereço campo obrigatorio !")
	private String enderecoestabelecimento;

	private String ieestabelecimento;

	private String latitudeestabelecimento;

	private String logitudeestabelecimento;
	
	private String nomefantasia;
	
	@NotNull(message="Razão Social campo obrigatorio !")
	private String razaosocial;

	private Integer situacaoestabelecimento;

	private String telefoneestabelecimento;

	private Integer albergadoestabelecimento;
	
	private Integer checkestabelecimento;
	
	private Integer numeroestabelecimento;

	private Integer ambulanteestabelecimento;
	
	private Integer enderecofiscal;
	
	private Integer idtipoempresa;
	
	private Integer numeroatividade;
	

	//bi-directional many-to-one association to Responsaveltecnico
	@ManyToOne
	@JoinColumn(name="idresponsavel")
	@NotNull(message = "Tecnico Campo Obrigatorio !")
	private Responsaveltecnico responsaveltecnico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	@NotNull(message = "Responsavél Campo Obrigatorio !")
	private Usuario usuario;

	public Estabelecimento() {
	}

	public Integer getIdestabelecimento() {
		return this.idestabelecimento;
	}

	public void setIdestabelecimento(Integer idestabelecimento) {
		this.idestabelecimento = idestabelecimento;
	}

	public String getAreaestabelecimento() {
		return this.areaestabelecimento;
	}

	public void setAreaestabelecimento(String areaestabelecimento) {
		this.areaestabelecimento = areaestabelecimento;
	}

	public String getBairroestabelecimento() {
		return this.bairroestabelecimento;
	}

	public void setBairroestabelecimento(String bairroestabelecimento) {
		this.bairroestabelecimento = bairroestabelecimento;
	}

	public String getCelularestabelecimento() {
		return this.celularestabelecimento;
	}

	public void setCelularestabelecimento(String celularestabelecimento) {
		this.celularestabelecimento = celularestabelecimento;
	}

	public String getCepestabelecimento() {
		return this.cepestabelecimento;
	}

	public void setCepestabelecimento(String cepestabelecimento) {
		this.cepestabelecimento = cepestabelecimento;
	}

	public Long getCmestabelecimento() {
		return this.cmestabelecimento;
	}

	public void setCmestabelecimento(Long cmestabelecimento) {
		this.cmestabelecimento = cmestabelecimento;
	}

	public Long getCnesestabelecimento() {
		return this.cnesestabelecimento;
	}

	public void setCnesestabelecimento(Long cnesestabelecimento) {
		this.cnesestabelecimento = cnesestabelecimento;
	}

	public String getCnpjestabelecimento() {
		return this.cnpjestabelecimento;
	}

	public void setCnpjestabelecimento(String cnpjestabelecimento) {
		this.cnpjestabelecimento = cnpjestabelecimento;
	}

	public String getCpfresponsavel() {
		return this.cpfresponsavel;
	}

	public void setCpfresponsavel(String cpfresponsavel) {
		this.cpfresponsavel = cpfresponsavel;
	}

	public Date getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getEmailestabelecimento() {
		return this.emailestabelecimento;
	}

	public void setEmailestabelecimento(String emailestabelecimento) {
		this.emailestabelecimento = emailestabelecimento;
	}

	public String getEnderecoestabelecimento() {
		return this.enderecoestabelecimento;
	}

	public void setEnderecoestabelecimento(String enderecoestabelecimento) {
		this.enderecoestabelecimento = enderecoestabelecimento;
	}

	public String getIeestabelecimento() {
		return this.ieestabelecimento;
	}

	public void setIeestabelecimento(String ieestabelecimento) {
		this.ieestabelecimento = ieestabelecimento;
	}

	public String getLatitudeestabelecimento() {
		return this.latitudeestabelecimento;
	}

	public void setLatitudeestabelecimento(String latitudeestabelecimento) {
		this.latitudeestabelecimento = latitudeestabelecimento;
	}

	public String getLogitudeestabelecimento() {
		return this.logitudeestabelecimento;
	}

	public void setLogitudeestabelecimento(String logitudeestabelecimento) {
		this.logitudeestabelecimento = logitudeestabelecimento;
	}

	public String getNomefantasia() {
		return this.nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public Integer getSituacaoestabelecimento() {
		return this.situacaoestabelecimento;
	}

	public void setSituacaoestabelecimento(Integer situacaoestabelecimento) {
		this.situacaoestabelecimento = situacaoestabelecimento;
	}

	public String getTelefoneestabelecimento() {
		return this.telefoneestabelecimento;
	}

	public void setTelefoneestabelecimento(String telefoneestabelecimento) {
		this.telefoneestabelecimento = telefoneestabelecimento;
	}


	public Responsaveltecnico getResponsaveltecnico() {
		return this.responsaveltecnico;
	}

	public void setResponsaveltecnico(Responsaveltecnico responsaveltecnico) {
		this.responsaveltecnico = responsaveltecnico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getAlbergadoestabelecimento() {
		return albergadoestabelecimento;
	}

	public void setAlbergadoestabelecimento(Integer albergadoestabelecimento) {
		this.albergadoestabelecimento = albergadoestabelecimento;
	}

	public Integer getCheckestabelecimento() {
		return checkestabelecimento;
	}

	public void setCheckestabelecimento(Integer checkestabelecimento) {
		this.checkestabelecimento = checkestabelecimento;
	}

	public Integer getNumeroestabelecimento() {
		return numeroestabelecimento;
	}

	public void setNumeroestabelecimento(Integer numeroestabelecimento) {
		this.numeroestabelecimento = numeroestabelecimento;
	}

	public Integer getAmbulanteestabelecimento() {
		return ambulanteestabelecimento;
	}

	public void setAmbulanteestabelecimento(Integer ambulanteestabelecimento) {
		this.ambulanteestabelecimento = ambulanteestabelecimento;
	}

	public Integer getEnderecofiscal() {
		return enderecofiscal;
	}

	public void setEnderecofiscal(Integer enderecofiscal) {
		this.enderecofiscal = enderecofiscal;
	}

	public Integer getIdtipoempresa() {
		return idtipoempresa;
	}

	public void setIdtipoempresa(Integer idtipoempresa) {
		this.idtipoempresa = idtipoempresa;
	}

	public Integer getNumeroatividade() {
		return numeroatividade;
	}

	public void setNumeroatividade(Integer numeroatividade) {
		this.numeroatividade = numeroatividade;
	}
	
	

}