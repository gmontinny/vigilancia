package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produtos database table.
 * 
 */
@Entity
@Table(name="produtos")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="produtos_idprodutos", sequenceName = "produtos_idprodutos_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="produtos_idprodutos")
	private Integer idprodutos;

	private Integer aditivoalimentoprodutos;

	private Integer agrotoxicoprodutos;

	private Integer aguamineralprodutos;

	private Integer aguapotavelprodutos;

	private Integer alimentosautorizadosprodutos;

	private Integer alimentosprontosprodutos;

	private Integer armazenarprodutos;

	private Integer comercializarprodutos;

	private Integer cosmeticosprodutos;

	private Integer dispensadoregistroprodutos;

	private Integer dispensarprodutos;

	private Integer distribuirprodutos;

	private Integer embalagemalimentoprodutos;

	private Integer embalarprodutos;

	private Integer exportarprodutos;

	private Integer fracionarprodutos;

	private Integer grupo1produtos;

	private Integer grupo2produtos;

	private Integer grupo3produtos;

	private Integer grupo5produtos;

	private Integer higieneprodutos;

	private Integer importarprodutos;

	private Integer manipularprodutos;

	private Integer medicamentonaoespecialprodutos;

	private Integer medicamentosespecialprodutos;

	private Integer oleovegetalprodutos;

	private Integer outrosprodutos;
	
	private String  outromesmoproduto;

	private Integer perfumariaprodutos;

	private Integer produzirprodutos;

	private Integer quimicosprodutos;

	private Integer reembalarprodutos;

	private Integer retinoicosprodutos;

	private Integer saneantesprodutos;

	private Integer saudeprodutos;

	private Integer suplementosprodutos;

	private Integer transportarprodutos;

	private Integer tratarprodutos;

	private Integer veterinarioprodutos;
	
	private Integer deferidofiscalproduto;
	
	private Integer outroscasosproduto;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	public Produto() {
	}

	public Integer getIdprodutos() {
		return this.idprodutos;
	}

	public void setIdprodutos(Integer idprodutos) {
		this.idprodutos = idprodutos;
	}

	public Integer getAditivoalimentoprodutos() {
		return this.aditivoalimentoprodutos;
	}

	public void setAditivoalimentoprodutos(Integer aditivoalimentoprodutos) {
		this.aditivoalimentoprodutos = aditivoalimentoprodutos;
	}

	public Integer getAgrotoxicoprodutos() {
		return this.agrotoxicoprodutos;
	}

	public void setAgrotoxicoprodutos(Integer agrotoxicoprodutos) {
		this.agrotoxicoprodutos = agrotoxicoprodutos;
	}

	public Integer getAguamineralprodutos() {
		return this.aguamineralprodutos;
	}

	public void setAguamineralprodutos(Integer aguamineralprodutos) {
		this.aguamineralprodutos = aguamineralprodutos;
	}

	public Integer getAguapotavelprodutos() {
		return this.aguapotavelprodutos;
	}

	public void setAguapotavelprodutos(Integer aguapotavelprodutos) {
		this.aguapotavelprodutos = aguapotavelprodutos;
	}

	public Integer getAlimentosautorizadosprodutos() {
		return this.alimentosautorizadosprodutos;
	}

	public void setAlimentosautorizadosprodutos(Integer alimentosautorizadosprodutos) {
		this.alimentosautorizadosprodutos = alimentosautorizadosprodutos;
	}

	public Integer getAlimentosprontosprodutos() {
		return this.alimentosprontosprodutos;
	}

	public void setAlimentosprontosprodutos(Integer alimentosprontosprodutos) {
		this.alimentosprontosprodutos = alimentosprontosprodutos;
	}

	public Integer getArmazenarprodutos() {
		return this.armazenarprodutos;
	}

	public void setArmazenarprodutos(Integer armazenarprodutos) {
		this.armazenarprodutos = armazenarprodutos;
	}

	public Integer getComercializarprodutos() {
		return this.comercializarprodutos;
	}

	public void setComercializarprodutos(Integer comercializarprodutos) {
		this.comercializarprodutos = comercializarprodutos;
	}

	public Integer getCosmeticosprodutos() {
		return this.cosmeticosprodutos;
	}

	public void setCosmeticosprodutos(Integer cosmeticosprodutos) {
		this.cosmeticosprodutos = cosmeticosprodutos;
	}

	public Integer getDispensadoregistroprodutos() {
		return this.dispensadoregistroprodutos;
	}

	public void setDispensadoregistroprodutos(Integer dispensadoregistroprodutos) {
		this.dispensadoregistroprodutos = dispensadoregistroprodutos;
	}

	public Integer getDispensarprodutos() {
		return this.dispensarprodutos;
	}

	public void setDispensarprodutos(Integer dispensarprodutos) {
		this.dispensarprodutos = dispensarprodutos;
	}

	public Integer getDistribuirprodutos() {
		return this.distribuirprodutos;
	}

	public void setDistribuirprodutos(Integer distribuirprodutos) {
		this.distribuirprodutos = distribuirprodutos;
	}

	public Integer getEmbalagemalimentoprodutos() {
		return this.embalagemalimentoprodutos;
	}

	public void setEmbalagemalimentoprodutos(Integer embalagemalimentoprodutos) {
		this.embalagemalimentoprodutos = embalagemalimentoprodutos;
	}

	public Integer getEmbalarprodutos() {
		return this.embalarprodutos;
	}

	public void setEmbalarprodutos(Integer embalarprodutos) {
		this.embalarprodutos = embalarprodutos;
	}

	public Integer getExportarprodutos() {
		return this.exportarprodutos;
	}

	public void setExportarprodutos(Integer exportarprodutos) {
		this.exportarprodutos = exportarprodutos;
	}

	public Integer getFracionarprodutos() {
		return this.fracionarprodutos;
	}

	public void setFracionarprodutos(Integer fracionarprodutos) {
		this.fracionarprodutos = fracionarprodutos;
	}

	public Integer getGrupo1produtos() {
		return this.grupo1produtos;
	}

	public void setGrupo1produtos(Integer grupo1produtos) {
		this.grupo1produtos = grupo1produtos;
	}

	public Integer getGrupo2produtos() {
		return this.grupo2produtos;
	}

	public void setGrupo2produtos(Integer grupo2produtos) {
		this.grupo2produtos = grupo2produtos;
	}

	public Integer getGrupo3produtos() {
		return this.grupo3produtos;
	}

	public void setGrupo3produtos(Integer grupo3produtos) {
		this.grupo3produtos = grupo3produtos;
	}

	public Integer getGrupo5produtos() {
		return this.grupo5produtos;
	}

	public void setGrupo5produtos(Integer grupo5produtos) {
		this.grupo5produtos = grupo5produtos;
	}

	public Integer getHigieneprodutos() {
		return this.higieneprodutos;
	}

	public void setHigieneprodutos(Integer higieneprodutos) {
		this.higieneprodutos = higieneprodutos;
	}

	public Integer getImportarprodutos() {
		return this.importarprodutos;
	}

	public void setImportarprodutos(Integer importarprodutos) {
		this.importarprodutos = importarprodutos;
	}

	public Integer getManipularprodutos() {
		return this.manipularprodutos;
	}

	public void setManipularprodutos(Integer manipularprodutos) {
		this.manipularprodutos = manipularprodutos;
	}

	public Integer getMedicamentonaoespecialprodutos() {
		return this.medicamentonaoespecialprodutos;
	}

	public void setMedicamentonaoespecialprodutos(Integer medicamentonaoespecialprodutos) {
		this.medicamentonaoespecialprodutos = medicamentonaoespecialprodutos;
	}

	public Integer getMedicamentosespecialprodutos() {
		return this.medicamentosespecialprodutos;
	}

	public void setMedicamentosespecialprodutos(Integer medicamentosespecialprodutos) {
		this.medicamentosespecialprodutos = medicamentosespecialprodutos;
	}

	public Integer getOleovegetalprodutos() {
		return this.oleovegetalprodutos;
	}

	public void setOleovegetalprodutos(Integer oleovegetalprodutos) {
		this.oleovegetalprodutos = oleovegetalprodutos;
	}

	public Integer getOutrosprodutos() {
		return this.outrosprodutos;
	}

	public void setOutrosprodutos(Integer outrosprodutos) {
		this.outrosprodutos = outrosprodutos;
	}

	public Integer getPerfumariaprodutos() {
		return this.perfumariaprodutos;
	}

	public void setPerfumariaprodutos(Integer perfumariaprodutos) {
		this.perfumariaprodutos = perfumariaprodutos;
	}

	public Integer getProduzirprodutos() {
		return this.produzirprodutos;
	}

	public void setProduzirprodutos(Integer produzirprodutos) {
		this.produzirprodutos = produzirprodutos;
	}

	public Integer getQuimicosprodutos() {
		return this.quimicosprodutos;
	}

	public void setQuimicosprodutos(Integer quimicosprodutos) {
		this.quimicosprodutos = quimicosprodutos;
	}

	public Integer getReembalarprodutos() {
		return this.reembalarprodutos;
	}

	public void setReembalarprodutos(Integer reembalarprodutos) {
		this.reembalarprodutos = reembalarprodutos;
	}

	public Integer getRetinoicosprodutos() {
		return this.retinoicosprodutos;
	}

	public void setRetinoicosprodutos(Integer retinoicosprodutos) {
		this.retinoicosprodutos = retinoicosprodutos;
	}

	public Integer getSaneantesprodutos() {
		return this.saneantesprodutos;
	}

	public void setSaneantesprodutos(Integer saneantesprodutos) {
		this.saneantesprodutos = saneantesprodutos;
	}

	public Integer getSaudeprodutos() {
		return this.saudeprodutos;
	}

	public void setSaudeprodutos(Integer saudeprodutos) {
		this.saudeprodutos = saudeprodutos;
	}

	public Integer getSuplementosprodutos() {
		return this.suplementosprodutos;
	}

	public void setSuplementosprodutos(Integer suplementosprodutos) {
		this.suplementosprodutos = suplementosprodutos;
	}

	public Integer getTransportarprodutos() {
		return this.transportarprodutos;
	}

	public void setTransportarprodutos(Integer transportarprodutos) {
		this.transportarprodutos = transportarprodutos;
	}

	public Integer getTratarprodutos() {
		return this.tratarprodutos;
	}

	public void setTratarprodutos(Integer tratarprodutos) {
		this.tratarprodutos = tratarprodutos;
	}

	public Integer getVeterinarioprodutos() {
		return this.veterinarioprodutos;
	}

	public void setVeterinarioprodutos(Integer veterinarioprodutos) {
		this.veterinarioprodutos = veterinarioprodutos;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public String getOutromesmoproduto() {
		return outromesmoproduto;
	}

	public void setOutromesmoproduto(String outromesmoproduto) {
		this.outromesmoproduto = outromesmoproduto;
	}

	public Integer getDeferidofiscalproduto() {
		return deferidofiscalproduto;
	}

	public void setDeferidofiscalproduto(Integer deferidofiscalproduto) {
		this.deferidofiscalproduto = deferidofiscalproduto;
	}

	public Integer getOutroscasosproduto() {
		return outroscasosproduto;
	}

	public void setOutroscasosproduto(Integer outroscasosproduto) {
		this.outroscasosproduto = outroscasosproduto;
	}
	
}