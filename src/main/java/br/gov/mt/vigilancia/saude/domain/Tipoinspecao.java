package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tipoinspecao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Tipoinspecao.findAll", query="SELECT t FROM Tipoinspecao t ORDER BY t.descricaotipoinspecao")
public class Tipoinspecao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipoinspecao_idtipoinspecao", sequenceName = "tipoinspecao_idtipoinspecao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="tipoinspecao_idtipoinspecao")
	private Integer idtipoinspecao;
	
	@NotNull(message="Descrição campo obrigatorio !")
	private String descricaotipoinspecao;
	
	private Integer analiseprocesso;
	
	private Integer autoinfracao;
	
	private Integer notificacao;
	
	private Integer colheita;
	
	private Integer arquitetonico;
	
	private Integer administrativo;

}