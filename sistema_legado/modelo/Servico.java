package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servicos database table.
 * 
 */
@Entity
@Table(name="servicos")
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="servicos_idservicos", sequenceName = "servicos_idservicos_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="servicos_idservicos")
	private Integer idservicos;

	private Integer albergueservicos;

	private Integer atividadessomatoservicos;

	private Integer atividadeveterinariaservicos;

	private Integer dependenciaquimicaservicos;

	private Integer esterilizacaoservicos;

	private Integer esteticaservicos;

	@Column(name="\"grupoAservicos\"")
	private Integer grupoAservicos;

	@Column(name="\"grupoBservicos\"")
	private Integer grupoBservicos;

	@Column(name="\"grupoCservicos\"")
	private Integer grupoCservicos;

	@Column(name="\"grupoDservicos\"")
	private Integer grupoDservicos;

	@Column(name="\"grupoEservicos\"")
	private Integer grupoEservicos;

	private Integer idososervicos;

	private Integer industrialservicos;

	private Integer laboratorioservicos;

	private Integer lavanderiadomesticaservicos;

	private Integer lavanderiaservicos;

	private Integer limpafossaservicos;

	private Integer limpezaarcondicionadoservicos;

	private Integer limpezacaixadaguaservicos;

	private Integer limpezaservicos;

	private Integer medicinatrabalhoservicos;

	private Integer pipaservicos;

	private Integer pragasservicos;

	private Integer saaservicos;

	private Integer salaobelezaservicos;

	private Integer tatuagemservicos;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	public Servico() {
	}

	public Integer getIdservicos() {
		return this.idservicos;
	}

	public void setIdservicos(Integer idservicos) {
		this.idservicos = idservicos;
	}

	public Integer getAlbergueservicos() {
		return this.albergueservicos;
	}

	public void setAlbergueservicos(Integer albergueservicos) {
		this.albergueservicos = albergueservicos;
	}

	public Integer getAtividadessomatoservicos() {
		return this.atividadessomatoservicos;
	}

	public void setAtividadessomatoservicos(Integer atividadessomatoservicos) {
		this.atividadessomatoservicos = atividadessomatoservicos;
	}

	public Integer getAtividadeveterinariaservicos() {
		return this.atividadeveterinariaservicos;
	}

	public void setAtividadeveterinariaservicos(Integer atividadeveterinariaservicos) {
		this.atividadeveterinariaservicos = atividadeveterinariaservicos;
	}

	public Integer getDependenciaquimicaservicos() {
		return this.dependenciaquimicaservicos;
	}

	public void setDependenciaquimicaservicos(Integer dependenciaquimicaservicos) {
		this.dependenciaquimicaservicos = dependenciaquimicaservicos;
	}

	public Integer getEsterilizacaoservicos() {
		return this.esterilizacaoservicos;
	}

	public void setEsterilizacaoservicos(Integer esterilizacaoservicos) {
		this.esterilizacaoservicos = esterilizacaoservicos;
	}

	public Integer getEsteticaservicos() {
		return this.esteticaservicos;
	}

	public void setEsteticaservicos(Integer esteticaservicos) {
		this.esteticaservicos = esteticaservicos;
	}

	public Integer getGrupoAservicos() {
		return this.grupoAservicos;
	}

	public void setGrupoAservicos(Integer grupoAservicos) {
		this.grupoAservicos = grupoAservicos;
	}

	public Integer getGrupoBservicos() {
		return this.grupoBservicos;
	}

	public void setGrupoBservicos(Integer grupoBservicos) {
		this.grupoBservicos = grupoBservicos;
	}

	public Integer getGrupoCservicos() {
		return this.grupoCservicos;
	}

	public void setGrupoCservicos(Integer grupoCservicos) {
		this.grupoCservicos = grupoCservicos;
	}

	public Integer getGrupoDservicos() {
		return this.grupoDservicos;
	}

	public void setGrupoDservicos(Integer grupoDservicos) {
		this.grupoDservicos = grupoDservicos;
	}

	public Integer getGrupoEservicos() {
		return this.grupoEservicos;
	}

	public void setGrupoEservicos(Integer grupoEservicos) {
		this.grupoEservicos = grupoEservicos;
	}

	public Integer getIdososervicos() {
		return this.idososervicos;
	}

	public void setIdososervicos(Integer idososervicos) {
		this.idososervicos = idososervicos;
	}

	public Integer getIndustrialservicos() {
		return this.industrialservicos;
	}

	public void setIndustrialservicos(Integer industrialservicos) {
		this.industrialservicos = industrialservicos;
	}

	public Integer getLaboratorioservicos() {
		return this.laboratorioservicos;
	}

	public void setLaboratorioservicos(Integer laboratorioservicos) {
		this.laboratorioservicos = laboratorioservicos;
	}

	public Integer getLavanderiadomesticaservicos() {
		return this.lavanderiadomesticaservicos;
	}

	public void setLavanderiadomesticaservicos(Integer lavanderiadomesticaservicos) {
		this.lavanderiadomesticaservicos = lavanderiadomesticaservicos;
	}

	public Integer getLavanderiaservicos() {
		return this.lavanderiaservicos;
	}

	public void setLavanderiaservicos(Integer lavanderiaservicos) {
		this.lavanderiaservicos = lavanderiaservicos;
	}

	public Integer getLimpafossaservicos() {
		return this.limpafossaservicos;
	}

	public void setLimpafossaservicos(Integer limpafossaservicos) {
		this.limpafossaservicos = limpafossaservicos;
	}

	public Integer getLimpezaarcondicionadoservicos() {
		return this.limpezaarcondicionadoservicos;
	}

	public void setLimpezaarcondicionadoservicos(Integer limpezaarcondicionadoservicos) {
		this.limpezaarcondicionadoservicos = limpezaarcondicionadoservicos;
	}

	public Integer getLimpezacaixadaguaservicos() {
		return this.limpezacaixadaguaservicos;
	}

	public void setLimpezacaixadaguaservicos(Integer limpezacaixadaguaservicos) {
		this.limpezacaixadaguaservicos = limpezacaixadaguaservicos;
	}

	public Integer getLimpezaservicos() {
		return this.limpezaservicos;
	}

	public void setLimpezaservicos(Integer limpezaservicos) {
		this.limpezaservicos = limpezaservicos;
	}

	public Integer getMedicinatrabalhoservicos() {
		return this.medicinatrabalhoservicos;
	}

	public void setMedicinatrabalhoservicos(Integer medicinatrabalhoservicos) {
		this.medicinatrabalhoservicos = medicinatrabalhoservicos;
	}

	public Integer getPipaservicos() {
		return this.pipaservicos;
	}

	public void setPipaservicos(Integer pipaservicos) {
		this.pipaservicos = pipaservicos;
	}

	public Integer getPragasservicos() {
		return this.pragasservicos;
	}

	public void setPragasservicos(Integer pragasservicos) {
		this.pragasservicos = pragasservicos;
	}

	public Integer getSaaservicos() {
		return this.saaservicos;
	}

	public void setSaaservicos(Integer saaservicos) {
		this.saaservicos = saaservicos;
	}

	public Integer getSalaobelezaservicos() {
		return this.salaobelezaservicos;
	}

	public void setSalaobelezaservicos(Integer salaobelezaservicos) {
		this.salaobelezaservicos = salaobelezaservicos;
	}

	public Integer getTatuagemservicos() {
		return this.tatuagemservicos;
	}

	public void setTatuagemservicos(Integer tatuagemservicos) {
		this.tatuagemservicos = tatuagemservicos;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}