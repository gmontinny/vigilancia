package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the processosolicitacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Processosolicitacao.findAll", query="SELECT p FROM Processosolicitacao p")
public class Processosolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="processosolicitacao_idprocessosolicitacao", sequenceName = "processosolicitacao_idprocessosolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="processosolicitacao_idprocessosolicitacao")
	private Integer idprocessosolicitacao;
	
	@NotNull(message="Numero de Processo campo Obrigatorio !")
	private String numprocesso;

	//bi-directional many-to-one association to Itenssolicitacao
	@ManyToOne
	@JoinColumn(name="iditenssolicitacao")
	@NotNull(message="Itens Solicitação campo obrigatorio !")
	private Itenssolicitacao itenssolicitacao;

}