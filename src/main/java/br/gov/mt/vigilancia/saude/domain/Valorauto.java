package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the valorauto database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Valorauto.findAll", query="SELECT v FROM Valorauto v ORDER BY v.valor")
public class Valorauto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="valorauto_idvalorauto", sequenceName = "valorauto_idvalorauto_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="valorauto_idvalorauto")
	private Integer idvalorauto;
	
	@NotNull(message="GRAU campo Obrigatório!")
	private Integer grauinfracao;

	@NotNull(message="VALOR campo Obrigatório!")
	private String valor;
	
	@NotNull(message="VALOR MINIMO campo Obrigatório!")
	private String valorminimo;

}