package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensatividade database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensatividade.findAll", query="SELECT i FROM Itensatividade i")
public class Itensatividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensatividade_iditensatividade", sequenceName = "itensatividade_iditensatividade_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensatividade_iditensatividade")
	private Integer iditensatividade;
	
	@ManyToOne
	@JoinColumn(name="idatividades")
	@NotNull(message="Atividade campo obrigatorio !")
	private Atividades atividades;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	@NotNull(message="Estebelecimento campo obrigatorio !")
	private Estabelecimento estabelecimento;

}