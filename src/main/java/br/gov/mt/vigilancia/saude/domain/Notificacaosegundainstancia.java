package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacaosegundainstancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaosegundainstancia.findAll", query="SELECT n FROM Notificacaosegundainstancia n ORDER BY n.idsegundainstancia DESC")
public class Notificacaosegundainstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaosegundainstancia_idsegundainstancia", sequenceName = "notificacaosegundainstancia_idsegundainstancia_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaosegundainstancia_idsegundainstancia")
	private Integer idsegundainstancia;
	
	@NotNull(message="Assinatura campo Obrigatorio !")
	private String assinatura;
	
	@NotNull(message="Coordenador(a) campo Obrigatorio !")
	private String coordenador;

	@NotNull(message="Texto campo Obrigatorio !")
	private String texto;
	
	private String tipo;

}