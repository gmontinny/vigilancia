package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the empresainfracoes database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="empresainfracoes", schema = "app")
@NamedQuery(name="Empresainfracoe.findAll", query="SELECT e FROM Empresainfracoe e")
public class Empresainfracoe implements Serializable {
	private static final long serialVersionUID = 1L;

 @Id
	@SequenceGenerator(name="empresainfracoes_idempresainfracoes", sequenceName = "empresainfracoes_idempresainfracoes_seq", schema = "app")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="empresainfracoes_idempresainfracoes")
	private Integer idempresainfracoes;

	@NotNull(message="TIPO EMPRESA campo Obrogatório!")
	private Integer tipoempresa;

	@NotNull(message="TIPO INFRAÇÕES campo Obrogatório!")
	private Integer tipoinfracoes;

	@NotNull(message="VALOR campo Obrogatório!")
	private double valor;

}