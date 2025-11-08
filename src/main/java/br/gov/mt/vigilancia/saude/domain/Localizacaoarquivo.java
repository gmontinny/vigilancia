package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the localizacaoarquivo database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Localizacaoarquivo.findAll", query="SELECT l FROM Localizacaoarquivo l")
public class Localizacaoarquivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="localizacaoarquivo_idlocalizacaoarquivo", sequenceName = "localizacaoarquivo_idlocalizacaoarquivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="localizacaoarquivo_idlocalizacaoarquivo")
	private Integer idlocalizacaoarquivo;
	
	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	@NotNull(message="Processo campo obrigatório !")
	private Processo processo;
	
	@NotNull(message="Tipo Localização campo obrigatório !")
	private Integer tipolocalizacao;
	
	@NotNull(message="Prateleira campo obrigatório !")
	private Integer prateleira;

}