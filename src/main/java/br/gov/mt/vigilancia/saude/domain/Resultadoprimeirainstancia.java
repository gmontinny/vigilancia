package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the resultadoprimeirainstancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Resultadoprimeirainstancia.findAll", query="SELECT r FROM Resultadoprimeirainstancia r")
public class Resultadoprimeirainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="resultadoprimeirainstancia_idresultadoprimeira", sequenceName = "resultadoprimeirainstancia_idresultadoprimeira_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="resultadoprimeirainstancia_idresultadoprimeira")
	private Integer idresultadoprimeira;

	@Temporal(TemporalType.DATE)	
	private Date datalancada;

	private Integer idusuario;

	private String numprocesso;

	private String tipoprocedencia;

}