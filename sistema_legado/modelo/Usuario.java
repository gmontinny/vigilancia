package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CPF;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u WHERE u.tipousuario IN (1,2,3,4,6) ORDER BY u.nomusuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="usuario_idusuario", sequenceName = "usuario_idusuario_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="usuario_idusuario")
	private Integer idusuario;

	private String celularusuario;
	
	@CPF(message="CPF invalido !")
	@NotNull(message="CPF campo obrogatorio !")
	private String cpfusuario;
	
	@NotNull(message="EMAIL campo obrogatorio !")
	private String emailusuario;

	private String imagemusuario;
	
	@NotNull(message="NOME campo obrogatorio !")
	@Size(min=5,message="NOME minimo 5 caracteres !")
	private String nomusuario;
	
	@NotNull(message="SENHA campo obrogatorio !")
	@Size(min=5,message="SENHA minimo 5 caracteres !")
	private String senusuario;

	private Integer sexousuario;
	
	private Integer advogadousuario;
	
	@NotNull(message="STATUS campo obrogatorio !")
	private Integer statususuario;
	
	@NotNull(message="TIPO campo obrogatorio !")
	private Integer tipousuario;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="usuario")
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to Estabelecimento
	@OneToMany(mappedBy="usuario")
	private List<Estabelecimento> estabelecimentos;

	//bi-directional many-to-one association to Fiscal
	@OneToMany(mappedBy="usuario")
	private List<Fiscal> fiscals;

	//bi-directional many-to-one association to Itensrelatorio
	@OneToMany(mappedBy="usuario")
	private List<Itensrelatorio> itensrelatorios;

	//bi-directional many-to-one association to Permissao
	@OneToMany(mappedBy="usuario")
	private List<Permissao> permissaos;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="usuario")
	private List<Processo> processos;
	
	private Integer auditorusuario;
	
	private Integer administrativousuario;
	
	private Integer statusenvio;
	
	private Integer coordenadorusuario;
	
	private Integer recursohumano;

	public Usuario() {
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getCelularusuario() {
		return this.celularusuario;
	}

	public void setCelularusuario(String celularusuario) {
		this.celularusuario = celularusuario;
	}

	public String getCpfusuario() {
		return this.cpfusuario;
	}

	public void setCpfusuario(String cpfusuario) {
		this.cpfusuario = cpfusuario;
	}

	public String getEmailusuario() {
		return this.emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getImagemusuario() {
		return this.imagemusuario;
	}

	public void setImagemusuario(String imagemusuario) {
		this.imagemusuario = imagemusuario;
	}

	public String getNomusuario() {
		return this.nomusuario;
	}

	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}

	public String getSenusuario() {
		return this.senusuario;
	}

	public void setSenusuario(String senusuario) {
		this.senusuario = senusuario;
	}

	public Integer getSexousuario() {
		return this.sexousuario;
	}

	public void setSexousuario(Integer sexousuario) {
		this.sexousuario = sexousuario;
	}

	public Integer getStatususuario() {
		return this.statususuario;
	}

	public void setStatususuario(Integer statususuario) {
		this.statususuario = statususuario;
	}

	public Integer getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Integer tipousuario) {
		this.tipousuario = tipousuario;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setUsuario(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setUsuario(null);

		return endereco;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return this.estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public Estabelecimento addEstabelecimento(Estabelecimento estabelecimento) {
		getEstabelecimentos().add(estabelecimento);
		estabelecimento.setUsuario(this);

		return estabelecimento;
	}

	public Estabelecimento removeEstabelecimento(Estabelecimento estabelecimento) {
		getEstabelecimentos().remove(estabelecimento);
		estabelecimento.setUsuario(null);

		return estabelecimento;
	}

	public List<Fiscal> getFiscals() {
		return this.fiscals;
	}

	public void setFiscals(List<Fiscal> fiscals) {
		this.fiscals = fiscals;
	}

	public Fiscal addFiscal(Fiscal fiscal) {
		getFiscals().add(fiscal);
		fiscal.setUsuario(this);

		return fiscal;
	}

	public Fiscal removeFiscal(Fiscal fiscal) {
		getFiscals().remove(fiscal);
		fiscal.setUsuario(null);

		return fiscal;
	}

	public List<Itensrelatorio> getItensrelatorios() {
		return this.itensrelatorios;
	}

	public void setItensrelatorios(List<Itensrelatorio> itensrelatorios) {
		this.itensrelatorios = itensrelatorios;
	}

	public Itensrelatorio addItensrelatorio(Itensrelatorio itensrelatorio) {
		getItensrelatorios().add(itensrelatorio);
		itensrelatorio.setUsuario(this);

		return itensrelatorio;
	}

	public Itensrelatorio removeItensrelatorio(Itensrelatorio itensrelatorio) {
		getItensrelatorios().remove(itensrelatorio);
		itensrelatorio.setUsuario(null);

		return itensrelatorio;
	}

	public List<Permissao> getPermissaos() {
		return this.permissaos;
	}

	public void setPermissaos(List<Permissao> permissaos) {
		this.permissaos = permissaos;
	}

	public Permissao addPermissao(Permissao permissao) {
		getPermissaos().add(permissao);
		permissao.setUsuario(this);

		return permissao;
	}

	public Permissao removePermissao(Permissao permissao) {
		getPermissaos().remove(permissao);
		permissao.setUsuario(null);

		return permissao;
	}

	public List<Processo> getProcessos() {
		return this.processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Processo addProcesso(Processo processo) {
		getProcessos().add(processo);
		processo.setUsuario(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setUsuario(null);

		return processo;
	}

	public Integer getAuditorusuario() {
		return auditorusuario;
	}

	public void setAuditorusuario(Integer auditorusuario) {
		this.auditorusuario = auditorusuario;
	}

	public Integer getAdvogadousuario() {
		return advogadousuario;
	}

	public void setAdvogadousuario(Integer advogadousuario) {
		this.advogadousuario = advogadousuario;
	}

	public Integer getAdministrativousuario() {
		return administrativousuario;
	}

	public void setAdministrativousuario(Integer administrativousuario) {
		this.administrativousuario = administrativousuario;
	}

	public Integer getStatusenvio() {
		return statusenvio;
	}

	public void setStatusenvio(Integer statusenvio) {
		this.statusenvio = statusenvio;
	}

	public Integer getCoordenadorusuario() {
		return coordenadorusuario;
	}

	public void setCoordenadorusuario(Integer coordenadorusuario) {
		this.coordenadorusuario = coordenadorusuario;
	}

	public Integer getRecursohumano() {
		return recursohumano;
	}

	public void setRecursohumano(Integer recursohumano) {
		this.recursohumano = recursohumano;
	}

	
	
}