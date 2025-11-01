package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the montarroteiro database table.
 * 
 */
@Entity
@Table(name = "montarroteiro", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Montarroteiro.findAll", query="SELECT m FROM Montarroteiro m ")
public class Montarroteiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="montarroteiro_idmontarroteiro", sequenceName = "app.montarroteiro_idmontarroteiro_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="montarroteiro_idmontarroteiro")
	private Integer idmontarroteiro;
	
	
	private Integer numeroroteiro;
	
	//bi-directional many-to-one association to Roteiro
	@ManyToOne
	@JoinColumn(name="idroteiro")
	private Roteiro roteiro;

}