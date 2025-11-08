package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the relatorio database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Relatorio.findAll", query="SELECT r FROM Relatorio r")
public class Relatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="relatorio_idrelatorio", sequenceName = "relatorio_idrelatorio_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="relatorio_idrelatorio")
	private Integer idrelatorio;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaorelatorio;
	
	@NotNull(message="Nome campo obrigatorio !")
	private String nomerelatorio;

	//bi-directional many-to-one association to Itensrelatorio
	@OneToMany(mappedBy="relatorio")
	private List<Itensrelatorio> itensrelatorios;

	public Itensrelatorio addItensrelatorio(Itensrelatorio itensrelatorio) {
		this.itensrelatorios.add(itensrelatorio);
		itensrelatorio.setRelatorio(this);

		return itensrelatorio;
	}

	public Itensrelatorio removeItensrelatorio(Itensrelatorio itensrelatorio) {
		this.itensrelatorios.remove(itensrelatorio);
		itensrelatorio.setRelatorio(null);

		return itensrelatorio;
	}

}