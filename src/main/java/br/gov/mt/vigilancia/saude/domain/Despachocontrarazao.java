package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the despachocontrarazao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Despachocontrarazao.findAll", query="SELECT d FROM Despachocontrarazao d ORDER BY d.iddespachocontrarazao DESC")
public class Despachocontrarazao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachocontrarazao_iddespachocontrarazao", sequenceName = "despachocontrarazao_iddespachocontrarazao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachocontrarazao_iddespachocontrarazao")
	private Integer iddespachocontrarazao;
	
	@NotNull(message="Gerente é um campo necessario !")
	private String gerenteresponsavel;

	private String imagemassinatura;

	@NotNull(message="Texto é um  campo Necessário !")
	private String textodespacho;

}