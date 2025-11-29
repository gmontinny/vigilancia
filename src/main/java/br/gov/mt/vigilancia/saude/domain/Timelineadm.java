package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the timelineadm database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Timelineadm.findAll", query="SELECT t FROM Timelineadm t")
public class Timelineadm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="timelineadm_idtimelineadm", sequenceName = "timelineadm_idtimelineadm_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="timelineadm_idtimelineadm")
	private Integer idtimelineadm;

	@Temporal(TemporalType.DATE)
	private Date data;

	private Time hora;

	private String numprocesso;

	private String processogerado;

	private String situacao;

}