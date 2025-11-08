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
 * The persistent class for the produtocategoria database table.
 * 
 */
@Entity
@Table(name = "produtocategoria", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Produtocategoria.findAll", query="SELECT p FROM ProdutoCategoria p ORDER BY p.nomeprodutocategoria")
public class ProdutoCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="produtocategoria_idprodutocategoria", sequenceName = "app.produtocategoria_idprodutocategoria_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtocategoria_idprodutocategoria")
	@Column(name = "id")
	private Integer idprodutocategoria;

	@NotNull(message="Nome campo obrigatorio !")
	private String nomeprodutocategoria;

	//bi-directional many-to-one association to Reclamacao
	@OneToMany(mappedBy="produtoCategoria")
	private List<Reclamacao> reclamacaos;

	public Reclamacao addReclamacao(Reclamacao reclamacao) {
		this.reclamacaos.add(reclamacao);
		reclamacao.setProdutoCategoria(this);

		return reclamacao;
	}

	public Reclamacao removeReclamacao(Reclamacao reclamacao) {
		this.reclamacaos.remove(reclamacao);
		reclamacao.setProdutoCategoria(null);

		return reclamacao;
	}

}