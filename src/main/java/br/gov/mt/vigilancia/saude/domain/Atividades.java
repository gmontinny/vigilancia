package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the atividadebpa database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Atividades.findAll", query="SELECT a FROM Atividades a ORDER BY a.descricaoatividades")
public class Atividades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="atividadebpa_idatividadebpa", sequenceName = "atividadebpa_idatividadebpa_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="atividadebpa_idatividadebpa")
	private Integer idatividades;
	
	@NotNull(message="Nome atividade campo obrigatorio !")
	private String descricaoatividades;

}