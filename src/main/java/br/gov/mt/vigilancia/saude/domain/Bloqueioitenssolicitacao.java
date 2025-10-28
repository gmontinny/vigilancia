package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the bloqueioitenssolicitacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Bloqueioitenssolicitacao.findAll", query="SELECT b FROM Bloqueioitenssolicitacao b")
public class Bloqueioitenssolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="bloqueioitenssolicitacao_idbloqueioitenssolicitacao", sequenceName = "bloqueioitenssolicitacao_idbloqueioitenssolicitacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="bloqueioitenssolicitacao_idbloqueioitenssolicitacao")
	private Integer idbloqueioitenssolicitacao;
	
	@ManyToOne
	@JoinColumn(name="iditenssolicitacao")
	private Itenssolicitacao itenssolicitacao;
	
	private Integer codigoreferencia;

}