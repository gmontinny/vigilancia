package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the processo database table.
 * 
 */
@Entity
@NamedQuery(name="Processo.findAll", query="SELECT p FROM Processo p")
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;

	@Temporal(TemporalType.DATE)
	private Date dataentrada;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estabelecimento campo obrigatorio !")
	private Estabelecimento estabelecimento;
	
	private Integer statusprocesso;
	
	private Integer resultadoprocesso;
	
	private String enderecoarquitetonico;
	
	//bi-directional many-to-one association to Analiseprocesso
	@OneToMany(mappedBy="processo")
	private List<Analiseprocesso> analiseprocessos;

	//bi-directional many-to-one association to Farmaceutico
	@OneToMany(mappedBy="processo")
	private List<Farmaceutico> farmaceuticos;

	//bi-directional many-to-one association to Ordemservico
	@OneToMany(mappedBy="processo")
	private List<Ordemservico> ordemservicos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="processo")
	private List<Produto> produtos;

	//bi-directional many-to-one association to Saude
	@OneToMany(mappedBy="processo")
	private List<Saude> saudes;

	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="processo")
	private List<Servico> servicos;
	
	private String observacao;

	public Processo() {
	}

	public String getNumprocesso() {
		return this.numprocesso;
	}

	public void setNumprocesso(String numprocesso) {
		this.numprocesso = numprocesso;
	}

	public Date getDataentrada() {
		return this.dataentrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.dataentrada = dataentrada;
	}
	
		
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Analiseprocesso> getAnaliseprocessos() {
		return this.analiseprocessos;
	}

	public void setAnaliseprocessos(List<Analiseprocesso> analiseprocessos) {
		this.analiseprocessos = analiseprocessos;
	}

	public Analiseprocesso addAnaliseprocesso(Analiseprocesso analiseprocesso) {
		getAnaliseprocessos().add(analiseprocesso);
		analiseprocesso.setProcesso(this);

		return analiseprocesso;
	}

	public Analiseprocesso removeAnaliseprocesso(Analiseprocesso analiseprocesso) {
		getAnaliseprocessos().remove(analiseprocesso);
		analiseprocesso.setProcesso(null);

		return analiseprocesso;
	}

	public List<Farmaceutico> getFarmaceuticos() {
		return this.farmaceuticos;
	}

	public void setFarmaceuticos(List<Farmaceutico> farmaceuticos) {
		this.farmaceuticos = farmaceuticos;
	}

	public Farmaceutico addFarmaceutico(Farmaceutico farmaceutico) {
		getFarmaceuticos().add(farmaceutico);
		farmaceutico.setProcesso(this);

		return farmaceutico;
	}

	public Farmaceutico removeFarmaceutico(Farmaceutico farmaceutico) {
		getFarmaceuticos().remove(farmaceutico);
		farmaceutico.setProcesso(null);

		return farmaceutico;
	}

	public List<Ordemservico> getOrdemservicos() {
		return this.ordemservicos;
	}

	public void setOrdemservicos(List<Ordemservico> ordemservicos) {
		this.ordemservicos = ordemservicos;
	}

	public Ordemservico addOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().add(ordemservico);
		ordemservico.setProcesso(this);

		return ordemservico;
	}

	public Ordemservico removeOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().remove(ordemservico);
		ordemservico.setProcesso(null);

		return ordemservico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setProcesso(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setProcesso(null);

		return produto;
	}

	public List<Saude> getSaudes() {
		return this.saudes;
	}

	public void setSaudes(List<Saude> saudes) {
		this.saudes = saudes;
	}

	public Saude addSaude(Saude saude) {
		getSaudes().add(saude);
		saude.setProcesso(this);

		return saude;
	}

	public Saude removeSaude(Saude saude) {
		getSaudes().remove(saude);
		saude.setProcesso(null);

		return saude;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setProcesso(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setProcesso(null);

		return servico;
	}

	public Integer getStatusprocesso() {
		return statusprocesso;
	}

	public void setStatusprocesso(Integer statusprocesso) {
		this.statusprocesso = statusprocesso;
	}

	public Integer getResultadoprocesso() {
		return resultadoprocesso;
	}

	public void setResultadoprocesso(Integer resultadoprocesso) {
		this.resultadoprocesso = resultadoprocesso;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEnderecoarquitetonico() {
		return enderecoarquitetonico;
	}

	public void setEnderecoarquitetonico(String enderecoarquitetonico) {
		this.enderecoarquitetonico = enderecoarquitetonico;
	}
	
	

	
}