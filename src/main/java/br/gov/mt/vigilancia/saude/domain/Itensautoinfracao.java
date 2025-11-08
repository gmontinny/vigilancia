package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensautoinfracao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensautoinfracao.findAll", query="SELECT i FROM Itensautoinfracao i")
public class Itensautoinfracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensautoinfracao_iditensautoinfracao", sequenceName = "itensautoinfracao_iditensautoinfracao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensautoinfracao_iditensautoinfracao")
	private Integer iditensautoinfracao;

	private Integer numeroauto;
	
	private String valoritens;
	
	private String textoitens;
	
	private String tiporisco;

	private Integer idlegislacao;

}