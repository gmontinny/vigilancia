package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensrelatorio database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensrelatorio.findAll", query="SELECT i FROM Itensrelatorio i")
public class Itensrelatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensrelatorio_iditensrelatorio", sequenceName = "itensrelatorio_iditensrelatorio_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensrelatorio_iditensrelatorio")
	private Integer iditensrelatorio;

	//bi-directional many-to-one association to Relatorio
	@ManyToOne
	@JoinColumn(name="idrelatorio")
	private Relatorio relatorio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

}