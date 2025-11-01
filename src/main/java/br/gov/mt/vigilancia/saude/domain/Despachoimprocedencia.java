package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the despachoimprocedencia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Despachoimprocedencia.findAll", query="SELECT d FROM Despachoimprocedencia d ORDER BY d.iddespachoimprocedencia DESC")
public class Despachoimprocedencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="despachoimprocedencia_iddespachoimprocedencia", sequenceName = "despachoimprocedencia_iddespachoimprocedencia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="despachoimprocedencia_iddespachoimprocedencia")
	private Integer iddespachoimprocedencia;
	
	@NotNull(message="Secretario campo Obrigatorio !")
	private String secreatriodespachoimprocedencia;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String textodespachoimprocedencia;

}