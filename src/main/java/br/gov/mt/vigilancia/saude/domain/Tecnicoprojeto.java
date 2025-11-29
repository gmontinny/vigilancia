package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tecnicoprojeto database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Tecnicoprojeto.findAll", query="SELECT t FROM Tecnicoprojeto t ORDER BY t.nometecnicoprojeto")
public class Tecnicoprojeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tecnicoprojeto_idtecnicoprojeto", sequenceName = "tecnicoprojeto_idtecnicoprojeto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tecnicoprojeto_idtecnicoprojeto")
	private Integer idtecnicoprojeto;

	private String celulartecnicoprojeto;

	@NotNull(message="Email campo obrigatorio !")
	@Email(message="Email invalido !")
	private String emailtecnicoprojeto;

	//bi-directional many-to-one association to Conselho
	@ManyToOne
	@JoinColumn(name="idconselho")
	@NotNull(message="Conselho campo obrigatorio !")
	private Conselho conselho;
	
	@NotNull(message="Nome Técnico campo obrigatorio !")
	private String nometecnicoprojeto;
	
	private String numprocesso;
	
	@NotNull(message="CPF campo obrigatorio !")
	private String cpftecnicoprojeto;

	private String numeroconselho;

}