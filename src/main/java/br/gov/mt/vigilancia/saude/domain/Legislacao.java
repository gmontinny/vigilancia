package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the legislacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Legislacao.findAll", query="SELECT l FROM Legislacao l")
public class Legislacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="legislacao_idlegislcao", sequenceName = "legislacao_idlegislacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="legislacao_idlegislcao")
	private Integer idlegislacao;

	@NotNull(message="Artigo campo obrigatorio !")
	private String artigolegislacao;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaolegislacao;

	private String incisolegislacao;
	
	private Integer decretolegislacao;

	@NotNull(message="Lei campo obrigatorio !")
	private String leilegislacao;
	
	private String paragrafolegislacao;

	private String valorlegislacao;
	
	private String riscolegislacao;

}