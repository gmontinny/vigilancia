package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the autonotificacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Autonotificacao.findAll", query="SELECT a FROM Autonotificacao a")
public class Autonotificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idautonotificacao;

	private String descricaonotificacao;

	@ManyToOne
	@JoinColumn(name="idtramitacao")
	private Tramitacao tramitacao;

	private Integer prazo;

}