package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the farmaceuticos database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="farmaceuticos", schema = "app")
@NamedQuery(name="Farmaceutico.findAll", query="SELECT f FROM Farmaceutico f")
public class Farmaceutico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="farmaceuticos_idfarmaceuticos", sequenceName = "app.farmaceuticos_idfarmaceuticos_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="farmaceuticos_idfarmaceuticos")
	private Integer idfarmaceuticos;

	private Integer administracaofarmaceuticos;

	private Integer afericaofarmaceuticos;

	private Integer atencaofarmaceuticos;

	private Integer entregafarmaceuticos;

	private Integer inalacaofarmaceuticos;

	private Integer perfuracaofarmaceuticos;

	private String quaisfarmaceuticos;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="numprocesso")
	private Processo processo;

}