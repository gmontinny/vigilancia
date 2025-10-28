package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itenssolicitacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itenssolicitacao.findAll", query="SELECT i FROM Itenssolicitacao i ORDER BY i.nomeitenssolicitacao")
public class Itenssolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itenssolicitacao_iditenssolicitacao", sequenceName = "itenssolicitacao_iditenssolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itenssolicitacao_iditenssolicitacao")
	private Integer iditenssolicitacao;

	@NotNull(message="Nome campo obrigatorio !")
	@Size(min=5,message="Digite pelo menos 5 caracteres !")
	private String nomeitenssolicitacao;

	//bi-directional many-to-one association to Solicitacao
	@ManyToOne
	@JoinColumn(name="idsolicitacao")
	@NotNull(message="Solicitação campo obrigatorio !")
	private Solicitacao solicitacao;
	
	private Integer restritoitenssolicitacao;

}