package br.mt.gov.vigilancia.saude.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the saude database table.
 * 
 */
@Entity
@NamedQuery(name="Saude.findAll", query="SELECT s FROM Saude s")
public class Saude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="saude_idsaude", sequenceName = "saude_idsaude_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="saude_idsaude")
	private Integer idsaude;

	private Integer acuputurasaude;

	private Integer aidssaude;

	private Integer atsaude;

	private Integer bancoleitesaude;

	private Integer bancoorgaosaude;

	private Integer bancosaude;

	private Integer bucosaude;

	private Integer cardiocosaude;

	private Integer cardiologiasaude;

	private Integer cirurgiageralsaude;

	private Integer citologiasaude;

	private Integer clinicasaude;

	private Integer clinicogeralsaude;

	private Integer coletasaude;

	private Integer cronicossaude;

	private Integer dermatologistasaude;

	private Integer dialisesaude;

	private Integer endocrinologiasaude;

	private Integer endoscopiasaude;

	private Integer enteralsaude;

	private Integer fisioterapiasaude;

	private Integer fonoaudiologiasaude;

	private Integer gastroenterologiasaude;

	private Integer geriatriasaude;

	private Integer ginecologiasaude;

	private Integer hansenologiasaude;

	private Integer hematologiasaude;

	private Integer hemodialisesaude;

	private Integer hemodinamicasaude;

	private Integer hiperbaricasaude;

	private Integer homecaresaude;

	private Integer lactariosaude;

	private Integer leitodiasaude;

	private Integer leitosaude;

	private Integer litotripsiasaude;

	private Integer medicoradiosaude;

	private Integer medicosaude;

	private Integer misoprostolsaude;

	private Integer nefrologiasaude;

	private Integer neonatologiasaude;

	private Integer neurocirurgiasaude;

	private Integer neurologiasaude;

	private Integer nutricaosaude;

	private Integer obstetricasaude;

	private Integer obstetriciasaude;

	private Integer odontologicocirurgicosaude;

	private Integer odontologicoradiosaude;

	private Integer odontologicosaude;

	private Integer oftalmologiasaude;

	private Integer oncologiasaude;

	private Integer oncologistasaude;

	private Integer otorrinolaringologiasaude;

	private Integer parentalsaude;

	private Integer patologiasaude;

	private Integer pediatriasaude;

	private Integer plasticasaude;

	private Integer pneumologiasaude;

	private Integer procedimentosaude;

	private Integer psicologiasaude;

	private Integer psiquiatriasaude;

	private Integer reabilitacaosaude;

	private Integer ressonanciasaude;

	private Integer substitutivasaude;

	private Integer tisiologiasaude;

	private Integer toraxicasaude;

	@Column(name="\"transporteAsaude\"")
	private Integer transporteAsaude;

	@Column(name="\"transporteBsaude\"")
	private Integer transporteBsaude;

	@Column(name="\"transporteCsaude\"")
	private Integer transporteCsaude;

	@Column(name="\"transporteDsaude\"")
	private Integer transporteDsaude;

	private Integer traumatologiasaude;

	private Integer uansaude;

	private Integer uctsaude;

	private Integer ultrassonografiasaude;

	private Integer unidadeisolamentosaude;

	private Integer unidadeneosaude;

	private Integer unidadesaude;

	private Integer urologiasaude;

	private Integer utiadultosaude;

	private Integer utiinfantilsaude;

	private Integer utineonatalsaude;

	private Integer veterinarioradiosaude;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

	public Saude() {
	}

	public Integer getIdsaude() {
		return this.idsaude;
	}

	public void setIdsaude(Integer idsaude) {
		this.idsaude = idsaude;
	}

	public Integer getAcuputurasaude() {
		return this.acuputurasaude;
	}

	public void setAcuputurasaude(Integer acuputurasaude) {
		this.acuputurasaude = acuputurasaude;
	}

	public Integer getAidssaude() {
		return this.aidssaude;
	}

	public void setAidssaude(Integer aidssaude) {
		this.aidssaude = aidssaude;
	}

	public Integer getAtsaude() {
		return this.atsaude;
	}

	public void setAtsaude(Integer atsaude) {
		this.atsaude = atsaude;
	}

	public Integer getBancoleitesaude() {
		return this.bancoleitesaude;
	}

	public void setBancoleitesaude(Integer bancoleitesaude) {
		this.bancoleitesaude = bancoleitesaude;
	}

	public Integer getBancoorgaosaude() {
		return this.bancoorgaosaude;
	}

	public void setBancoorgaosaude(Integer bancoorgaosaude) {
		this.bancoorgaosaude = bancoorgaosaude;
	}

	public Integer getBancosaude() {
		return this.bancosaude;
	}

	public void setBancosaude(Integer bancosaude) {
		this.bancosaude = bancosaude;
	}

	public Integer getBucosaude() {
		return this.bucosaude;
	}

	public void setBucosaude(Integer bucosaude) {
		this.bucosaude = bucosaude;
	}

	public Integer getCardiocosaude() {
		return this.cardiocosaude;
	}

	public void setCardiocosaude(Integer cardiocosaude) {
		this.cardiocosaude = cardiocosaude;
	}

	public Integer getCardiologiasaude() {
		return this.cardiologiasaude;
	}

	public void setCardiologiasaude(Integer cardiologiasaude) {
		this.cardiologiasaude = cardiologiasaude;
	}

	public Integer getCirurgiageralsaude() {
		return this.cirurgiageralsaude;
	}

	public void setCirurgiageralsaude(Integer cirurgiageralsaude) {
		this.cirurgiageralsaude = cirurgiageralsaude;
	}

	public Integer getCitologiasaude() {
		return this.citologiasaude;
	}

	public void setCitologiasaude(Integer citologiasaude) {
		this.citologiasaude = citologiasaude;
	}

	public Integer getClinicasaude() {
		return this.clinicasaude;
	}

	public void setClinicasaude(Integer clinicasaude) {
		this.clinicasaude = clinicasaude;
	}

	public Integer getClinicogeralsaude() {
		return this.clinicogeralsaude;
	}

	public void setClinicogeralsaude(Integer clinicogeralsaude) {
		this.clinicogeralsaude = clinicogeralsaude;
	}

	public Integer getColetasaude() {
		return this.coletasaude;
	}

	public void setColetasaude(Integer coletasaude) {
		this.coletasaude = coletasaude;
	}

	public Integer getCronicossaude() {
		return this.cronicossaude;
	}

	public void setCronicossaude(Integer cronicossaude) {
		this.cronicossaude = cronicossaude;
	}

	public Integer getDermatologistasaude() {
		return this.dermatologistasaude;
	}

	public void setDermatologistasaude(Integer dermatologistasaude) {
		this.dermatologistasaude = dermatologistasaude;
	}

	public Integer getDialisesaude() {
		return this.dialisesaude;
	}

	public void setDialisesaude(Integer dialisesaude) {
		this.dialisesaude = dialisesaude;
	}

	public Integer getEndocrinologiasaude() {
		return this.endocrinologiasaude;
	}

	public void setEndocrinologiasaude(Integer endocrinologiasaude) {
		this.endocrinologiasaude = endocrinologiasaude;
	}

	public Integer getEndoscopiasaude() {
		return this.endoscopiasaude;
	}

	public void setEndoscopiasaude(Integer endoscopiasaude) {
		this.endoscopiasaude = endoscopiasaude;
	}

	public Integer getEnteralsaude() {
		return this.enteralsaude;
	}

	public void setEnteralsaude(Integer enteralsaude) {
		this.enteralsaude = enteralsaude;
	}

	public Integer getFisioterapiasaude() {
		return this.fisioterapiasaude;
	}

	public void setFisioterapiasaude(Integer fisioterapiasaude) {
		this.fisioterapiasaude = fisioterapiasaude;
	}

	public Integer getFonoaudiologiasaude() {
		return this.fonoaudiologiasaude;
	}

	public void setFonoaudiologiasaude(Integer fonoaudiologiasaude) {
		this.fonoaudiologiasaude = fonoaudiologiasaude;
	}

	public Integer getGastroenterologiasaude() {
		return this.gastroenterologiasaude;
	}

	public void setGastroenterologiasaude(Integer gastroenterologiasaude) {
		this.gastroenterologiasaude = gastroenterologiasaude;
	}

	public Integer getGeriatriasaude() {
		return this.geriatriasaude;
	}

	public void setGeriatriasaude(Integer geriatriasaude) {
		this.geriatriasaude = geriatriasaude;
	}

	public Integer getGinecologiasaude() {
		return this.ginecologiasaude;
	}

	public void setGinecologiasaude(Integer ginecologiasaude) {
		this.ginecologiasaude = ginecologiasaude;
	}

	public Integer getHansenologiasaude() {
		return this.hansenologiasaude;
	}

	public void setHansenologiasaude(Integer hansenologiasaude) {
		this.hansenologiasaude = hansenologiasaude;
	}

	public Integer getHematologiasaude() {
		return this.hematologiasaude;
	}

	public void setHematologiasaude(Integer hematologiasaude) {
		this.hematologiasaude = hematologiasaude;
	}

	public Integer getHemodialisesaude() {
		return this.hemodialisesaude;
	}

	public void setHemodialisesaude(Integer hemodialisesaude) {
		this.hemodialisesaude = hemodialisesaude;
	}

	public Integer getHemodinamicasaude() {
		return this.hemodinamicasaude;
	}

	public void setHemodinamicasaude(Integer hemodinamicasaude) {
		this.hemodinamicasaude = hemodinamicasaude;
	}

	public Integer getHiperbaricasaude() {
		return this.hiperbaricasaude;
	}

	public void setHiperbaricasaude(Integer hiperbaricasaude) {
		this.hiperbaricasaude = hiperbaricasaude;
	}

	public Integer getHomecaresaude() {
		return this.homecaresaude;
	}

	public void setHomecaresaude(Integer homecaresaude) {
		this.homecaresaude = homecaresaude;
	}

	public Integer getLactariosaude() {
		return this.lactariosaude;
	}

	public void setLactariosaude(Integer lactariosaude) {
		this.lactariosaude = lactariosaude;
	}

	public Integer getLeitodiasaude() {
		return this.leitodiasaude;
	}

	public void setLeitodiasaude(Integer leitodiasaude) {
		this.leitodiasaude = leitodiasaude;
	}

	public Integer getLeitosaude() {
		return this.leitosaude;
	}

	public void setLeitosaude(Integer leitosaude) {
		this.leitosaude = leitosaude;
	}

	public Integer getLitotripsiasaude() {
		return this.litotripsiasaude;
	}

	public void setLitotripsiasaude(Integer litotripsiasaude) {
		this.litotripsiasaude = litotripsiasaude;
	}

	public Integer getMedicoradiosaude() {
		return this.medicoradiosaude;
	}

	public void setMedicoradiosaude(Integer medicoradiosaude) {
		this.medicoradiosaude = medicoradiosaude;
	}

	public Integer getMedicosaude() {
		return this.medicosaude;
	}

	public void setMedicosaude(Integer medicosaude) {
		this.medicosaude = medicosaude;
	}

	public Integer getMisoprostolsaude() {
		return this.misoprostolsaude;
	}

	public void setMisoprostolsaude(Integer misoprostolsaude) {
		this.misoprostolsaude = misoprostolsaude;
	}

	public Integer getNefrologiasaude() {
		return this.nefrologiasaude;
	}

	public void setNefrologiasaude(Integer nefrologiasaude) {
		this.nefrologiasaude = nefrologiasaude;
	}

	public Integer getNeonatologiasaude() {
		return this.neonatologiasaude;
	}

	public void setNeonatologiasaude(Integer neonatologiasaude) {
		this.neonatologiasaude = neonatologiasaude;
	}

	public Integer getNeurocirurgiasaude() {
		return this.neurocirurgiasaude;
	}

	public void setNeurocirurgiasaude(Integer neurocirurgiasaude) {
		this.neurocirurgiasaude = neurocirurgiasaude;
	}

	public Integer getNeurologiasaude() {
		return this.neurologiasaude;
	}

	public void setNeurologiasaude(Integer neurologiasaude) {
		this.neurologiasaude = neurologiasaude;
	}

	public Integer getNutricaosaude() {
		return this.nutricaosaude;
	}

	public void setNutricaosaude(Integer nutricaosaude) {
		this.nutricaosaude = nutricaosaude;
	}

	public Integer getObstetricasaude() {
		return this.obstetricasaude;
	}

	public void setObstetricasaude(Integer obstetricasaude) {
		this.obstetricasaude = obstetricasaude;
	}

	public Integer getObstetriciasaude() {
		return this.obstetriciasaude;
	}

	public void setObstetriciasaude(Integer obstetriciasaude) {
		this.obstetriciasaude = obstetriciasaude;
	}

	public Integer getOdontologicocirurgicosaude() {
		return this.odontologicocirurgicosaude;
	}

	public void setOdontologicocirurgicosaude(Integer odontologicocirurgicosaude) {
		this.odontologicocirurgicosaude = odontologicocirurgicosaude;
	}

	public Integer getOdontologicoradiosaude() {
		return this.odontologicoradiosaude;
	}

	public void setOdontologicoradiosaude(Integer odontologicoradiosaude) {
		this.odontologicoradiosaude = odontologicoradiosaude;
	}

	public Integer getOdontologicosaude() {
		return this.odontologicosaude;
	}

	public void setOdontologicosaude(Integer odontologicosaude) {
		this.odontologicosaude = odontologicosaude;
	}

	public Integer getOftalmologiasaude() {
		return this.oftalmologiasaude;
	}

	public void setOftalmologiasaude(Integer oftalmologiasaude) {
		this.oftalmologiasaude = oftalmologiasaude;
	}

	public Integer getOncologiasaude() {
		return this.oncologiasaude;
	}

	public void setOncologiasaude(Integer oncologiasaude) {
		this.oncologiasaude = oncologiasaude;
	}

	public Integer getOncologistasaude() {
		return this.oncologistasaude;
	}

	public void setOncologistasaude(Integer oncologistasaude) {
		this.oncologistasaude = oncologistasaude;
	}

	public Integer getOtorrinolaringologiasaude() {
		return this.otorrinolaringologiasaude;
	}

	public void setOtorrinolaringologiasaude(Integer otorrinolaringologiasaude) {
		this.otorrinolaringologiasaude = otorrinolaringologiasaude;
	}

	public Integer getParentalsaude() {
		return this.parentalsaude;
	}

	public void setParentalsaude(Integer parentalsaude) {
		this.parentalsaude = parentalsaude;
	}

	public Integer getPatologiasaude() {
		return this.patologiasaude;
	}

	public void setPatologiasaude(Integer patologiasaude) {
		this.patologiasaude = patologiasaude;
	}

	public Integer getPediatriasaude() {
		return this.pediatriasaude;
	}

	public void setPediatriasaude(Integer pediatriasaude) {
		this.pediatriasaude = pediatriasaude;
	}

	public Integer getPlasticasaude() {
		return this.plasticasaude;
	}

	public void setPlasticasaude(Integer plasticasaude) {
		this.plasticasaude = plasticasaude;
	}

	public Integer getPneumologiasaude() {
		return this.pneumologiasaude;
	}

	public void setPneumologiasaude(Integer pneumologiasaude) {
		this.pneumologiasaude = pneumologiasaude;
	}

	public Integer getProcedimentosaude() {
		return this.procedimentosaude;
	}

	public void setProcedimentosaude(Integer procedimentosaude) {
		this.procedimentosaude = procedimentosaude;
	}

	public Integer getPsicologiasaude() {
		return this.psicologiasaude;
	}

	public void setPsicologiasaude(Integer psicologiasaude) {
		this.psicologiasaude = psicologiasaude;
	}

	public Integer getPsiquiatriasaude() {
		return this.psiquiatriasaude;
	}

	public void setPsiquiatriasaude(Integer psiquiatriasaude) {
		this.psiquiatriasaude = psiquiatriasaude;
	}

	public Integer getReabilitacaosaude() {
		return this.reabilitacaosaude;
	}

	public void setReabilitacaosaude(Integer reabilitacaosaude) {
		this.reabilitacaosaude = reabilitacaosaude;
	}

	public Integer getRessonanciasaude() {
		return this.ressonanciasaude;
	}

	public void setRessonanciasaude(Integer ressonanciasaude) {
		this.ressonanciasaude = ressonanciasaude;
	}

	public Integer getSubstitutivasaude() {
		return this.substitutivasaude;
	}

	public void setSubstitutivasaude(Integer substitutivasaude) {
		this.substitutivasaude = substitutivasaude;
	}

	public Integer getTisiologiasaude() {
		return this.tisiologiasaude;
	}

	public void setTisiologiasaude(Integer tisiologiasaude) {
		this.tisiologiasaude = tisiologiasaude;
	}

	public Integer getToraxicasaude() {
		return this.toraxicasaude;
	}

	public void setToraxicasaude(Integer toraxicasaude) {
		this.toraxicasaude = toraxicasaude;
	}

	public Integer getTransporteAsaude() {
		return this.transporteAsaude;
	}

	public void setTransporteAsaude(Integer transporteAsaude) {
		this.transporteAsaude = transporteAsaude;
	}

	public Integer getTransporteBsaude() {
		return this.transporteBsaude;
	}

	public void setTransporteBsaude(Integer transporteBsaude) {
		this.transporteBsaude = transporteBsaude;
	}

	public Integer getTransporteCsaude() {
		return this.transporteCsaude;
	}

	public void setTransporteCsaude(Integer transporteCsaude) {
		this.transporteCsaude = transporteCsaude;
	}

	public Integer getTransporteDsaude() {
		return this.transporteDsaude;
	}

	public void setTransporteDsaude(Integer transporteDsaude) {
		this.transporteDsaude = transporteDsaude;
	}

	public Integer getTraumatologiasaude() {
		return this.traumatologiasaude;
	}

	public void setTraumatologiasaude(Integer traumatologiasaude) {
		this.traumatologiasaude = traumatologiasaude;
	}

	public Integer getUansaude() {
		return this.uansaude;
	}

	public void setUansaude(Integer uansaude) {
		this.uansaude = uansaude;
	}

	public Integer getUctsaude() {
		return this.uctsaude;
	}

	public void setUctsaude(Integer uctsaude) {
		this.uctsaude = uctsaude;
	}

	public Integer getUltrassonografiasaude() {
		return this.ultrassonografiasaude;
	}

	public void setUltrassonografiasaude(Integer ultrassonografiasaude) {
		this.ultrassonografiasaude = ultrassonografiasaude;
	}

	public Integer getUnidadeisolamentosaude() {
		return this.unidadeisolamentosaude;
	}

	public void setUnidadeisolamentosaude(Integer unidadeisolamentosaude) {
		this.unidadeisolamentosaude = unidadeisolamentosaude;
	}

	public Integer getUnidadeneosaude() {
		return this.unidadeneosaude;
	}

	public void setUnidadeneosaude(Integer unidadeneosaude) {
		this.unidadeneosaude = unidadeneosaude;
	}

	public Integer getUnidadesaude() {
		return this.unidadesaude;
	}

	public void setUnidadesaude(Integer unidadesaude) {
		this.unidadesaude = unidadesaude;
	}

	public Integer getUrologiasaude() {
		return this.urologiasaude;
	}

	public void setUrologiasaude(Integer urologiasaude) {
		this.urologiasaude = urologiasaude;
	}

	public Integer getUtiadultosaude() {
		return this.utiadultosaude;
	}

	public void setUtiadultosaude(Integer utiadultosaude) {
		this.utiadultosaude = utiadultosaude;
	}

	public Integer getUtiinfantilsaude() {
		return this.utiinfantilsaude;
	}

	public void setUtiinfantilsaude(Integer utiinfantilsaude) {
		this.utiinfantilsaude = utiinfantilsaude;
	}

	public Integer getUtineonatalsaude() {
		return this.utineonatalsaude;
	}

	public void setUtineonatalsaude(Integer utineonatalsaude) {
		this.utineonatalsaude = utineonatalsaude;
	}

	public Integer getVeterinarioradiosaude() {
		return this.veterinarioradiosaude;
	}

	public void setVeterinarioradiosaude(Integer veterinarioradiosaude) {
		this.veterinarioradiosaude = veterinarioradiosaude;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}