package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tramiteadm database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Tramiteadm.findAll", query="SELECT t FROM Tramiteadm t")
public class Tramiteadm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tramiteadm_idtramiteadm", sequenceName = "tramiteadm_idtramiteadm_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tramiteadm_idtramiteadm")
	private Integer idtramiteadm;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Data Final campo obrigatório!")
	private Date datafinal;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Data Inicial campo obrigatório!")
	private Date datainicial;

	private Integer idusuario;

	private Integer numerotramiteadm;
	
	private String numprocesso;

	private String situacao;

	private Integer status;
	
	private Integer numeroauto;

}