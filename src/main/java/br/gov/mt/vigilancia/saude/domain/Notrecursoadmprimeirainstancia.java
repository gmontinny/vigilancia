package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notrecursoadmprimeirainstancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notrecursoadmprimeirainstancia.findAll", query="SELECT n FROM Notrecursoadmprimeirainstancia n ORDER BY n.idnotrecursoadmprimeirainstancia DESC")
public class Notrecursoadmprimeirainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan", sequenceName = "notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notrecursoadmprimeirainstanci_idnotrecursoadmprimeirainstan")
	private Integer idnotrecursoadmprimeirainstancia;
	
	@NotNull(message="Assinatura campo Obrigatorio !")
	private String assinatura;

	@NotNull(message="Coordenador campo Obrigatorio !")
	private String coordenador;

	@Temporal(TemporalType.DATE)
	private Date datarecursoadministrativo;

	private Time horarecursoadministrativo;

	@NotNull(message="Texto campo Obrigatorio !")
	private String textorecursoadministrativo;

}