package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itenscategoriaservico database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itenscategoriaservico.findAll", query="SELECT i FROM Itenscategoriaservico i")
public class Itenscategoriaservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itenscategoria_iditenscategoriaservico", sequenceName = "itenscategoria_iditenscategoriaservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itenscategoria_iditenscategoriaservico")
	private Integer iditenscategoriaservico;

	@NotNull(message="DESCRIÇÃO do Serviço campo Obrigatorio !")
	private String descitenscategoriaservico;

	@NotNull(message="N° Serviço campo Obrigatorio !")
	private Integer numeroservico;

}