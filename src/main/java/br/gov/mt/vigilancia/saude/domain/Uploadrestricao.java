package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the uploadrestricao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Uploadrestricao.findAll", query="SELECT u FROM Uploadrestricao u")
public class Uploadrestricao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="uploadrestricao_iduploadrestricao", sequenceName = "uploadrestricao_iduploadrestricao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="uploadrestricao_iduploadrestricao")
	private Integer iduploadrestricao;

	@NotNull(message = "ITENSSOLICITAÇÃO campo Obrigatório !")
	private Integer iditenssolicitacao;

	@NotNull(message = "TOTAL DOCUMENTO campo Obrigatório !")
	private Integer totaldocumentos;
	
	private String descricao;

}