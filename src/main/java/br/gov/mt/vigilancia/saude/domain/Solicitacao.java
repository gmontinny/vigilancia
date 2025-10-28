package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the solicitacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Solicitacao.findAll", query="SELECT s FROM Solicitacao s")
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="solicitacao_idsolicitacao", sequenceName = "solicitacao_idsolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="solicitacao_idsolicitacao")
	private Integer idsolicitacao;
	
	@NotNull(message="Nome campo obrigatorio!")
	@Size(min=5, message="Digite no minimo 5 caracteres !")
	private String nomesolicitacao;

	//bi-directional many-to-one association to Itenssolicitacao
	@OneToMany(mappedBy="solicitacao")
	private List<Itenssolicitacao> itenssolicitacaos;

	public Itenssolicitacao addItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		this.itenssolicitacaos.add(itenssolicitacao);
		itenssolicitacao.setSolicitacao(this);

		return itenssolicitacao;
	}

	public Itenssolicitacao removeItenssolicitacao(Itenssolicitacao itenssolicitacao) {
		this.itenssolicitacaos.remove(itenssolicitacao);
		itenssolicitacao.setSolicitacao(null);

		return itenssolicitacao;
	}

}