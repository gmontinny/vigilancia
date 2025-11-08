package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensgaleria database table.
 * 
 */
@Entity
@Table(name = "itensgaleria", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensgaleria.findAll", query="SELECT i FROM Itensgaleria i")
public class Itensgaleria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensgaleria_iditensgaleria", sequenceName = "itensgaleria_iditensgaleria_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensgaleria_iditensgaleria")
	private Integer iditensgaleria;

	private String imagemitensgaleria;

	private Integer seguenciagaleria;

	private String tituloitensgaleria;

}