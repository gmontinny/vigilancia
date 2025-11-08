package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensdocumento database table.
 * 
 */
@Entity
@Table(name = "itensdocumento", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensdocumento.findAll", query="SELECT i FROM Itensdocumento i")
public class Itensdocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensdocumento_iditensdocumento", sequenceName = "itensdocumento_iditensdocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensdocumento_iditensdocumento")
	private Integer iditensdocumento;

	@NotNull(message="NOME ARQUIVO campo Obrigatorio !")
	private String nomearquivo;

	private Integer numerodocumento;

	@NotNull(message="ARQUIVO campo Obrigatorio !")
	private String oldarquivo;

	@NotNull(message="TIPO ARQUIVO campo Obrigatorio !")
	private String tipoarquivo;
	
	private Integer status;

}