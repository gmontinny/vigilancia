package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the categoriaproduto database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Categoriaproduto.findAll", query="SELECT c FROM Categoriaproduto c")
public class Categoriaproduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="categoriaproduto_idcategoriaproduto", sequenceName = "categoriaproduto_idcategoriaproduto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="categoriaproduto_idcategoriaproduto")
	private Integer idcategoriaproduto;

	@NotNull(message="Categoria do Produto campo Obrigatorio !")
	private String descricaocategoriaproduto;

	@NotNull(message="Código do Prodir campo obrigatorio !")
	private Integer codigoprodi;

}