package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the exiberoteiro database table.
 * 
 */
@Entity
@Table(name = "exiberoteiro", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Exiberoteiro.findAll", query="SELECT e FROM Exiberoteiro e")
public class Exiberoteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="exiberoteiro_idexiberoteiro", sequenceName = "app.exiberoteiro_idexiberoteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="exiberoteiro_idexiberoteiro")
	private Integer idexiberoteiro;
	
	@ManyToOne
	@JoinColumn(name="idmontarroteiro")
	private Montarroteiro montarroteiro;
	
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

}