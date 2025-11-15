package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacaorecurso database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaorecurso.findAll", query="SELECT n FROM Notificacaorecurso n")
public class Notificacaorecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaorecurso_idnotificacaorecurso", sequenceName = "notificacaorecurso_idnotificacaorecurso_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaorecurso_idnotificacaorecurso")
	private Integer idnotificacaorecurso;
	
	private String assinaturacoordenador;

	@NotNull(message="Coordenador(a) campo Obrigatorio !")
	private String coordenadorarecursonotificacao;

	@NotNull(message="Texto campo Obrigatorio !")
	private String textonotificacaorecurso;

}