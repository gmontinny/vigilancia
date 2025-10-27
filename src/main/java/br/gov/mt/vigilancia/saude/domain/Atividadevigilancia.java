package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the atividadevigilancia database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Atividadevigilancia.findAll", query="SELECT a FROM Atividadevigilancia a")
public class Atividadevigilancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="atividadevigilancia_idatividade", sequenceName = "atividadevigilancia_idatividade_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="atividadevigilancia_idatividade")
	private Integer idatividade;

	@ManyToOne
	@JoinColumn(name="idlicenciamento")
	private Licenciamento licenciamento;	
	
	private Integer liberacao;
	
	private Integer numeroatividade;

}