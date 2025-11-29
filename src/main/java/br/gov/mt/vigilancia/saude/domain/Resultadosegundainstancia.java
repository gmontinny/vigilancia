package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the resultadosegundainstancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Resultadosegundainstancia.findAll", query="SELECT r FROM Resultadosegundainstancia r")
public class Resultadosegundainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="resultadosegundainstancia_idresultadosegunda_seq", sequenceName = "resultadosegundainstancia_idresultadosegunda_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="resultadosegundainstancia_idresultadosegunda_seq")
	private Integer idresultadosegunda;

	@Temporal(TemporalType.DATE)
	private Date datalancada;

	private Integer idusuario;

	private String numprocesso;

	private String tipoprocedencia;

}