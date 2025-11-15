package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacaoprimeirainstancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaoprimeirainstancia.findAll", query="SELECT n FROM Notificacaoprimeirainstancia n ORDER BY n.idprimeirainstancia DESC")
public class Notificacaoprimeirainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaoprimeirainstancia_idprimeirainstancia", sequenceName = "notificacaoprimeirainstancia_idprimeirainstancia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaoprimeirainstancia_idprimeirainstancia")
	private Integer idprimeirainstancia;
	
	@NotNull(message="Assinatura campo Obrigatorio !")
	private String assinatura;

	@NotNull(message="Coordenador(a) campo Obrigatorio !")
	private String coordenador;
	
	@NotNull(message="Texto campo Obrigatorio !")
	private String texto;

}