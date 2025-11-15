package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the outroresponsavel database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Outroresponsavel.findAll", query="SELECT o FROM Outroresponsavel o")
public class Outroresponsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="outroresponsavel_idoutrosresponsaveis", sequenceName = "outroresponsavel_idoutrosresponsaveis_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="outroresponsavel_idoutrosresponsaveis")
	private Integer idoutrosresponsaveis;

	@ManyToOne
	@JoinColumn(name="idconselho")
	@NotNull(message="Conselho campo Obrigatorio !")
	private Conselho conselho;

	@NotNull(message="Responsavel campo Obrigatorio !")
	private String nomeresponsavel;

	private Integer numeroestabelecimento;

	@NotNull(message="Setor campo Obrigatorio !")
	private String setorresponsavel;
	
	@NotNull(message="N° Conselho campo Obrigatorio !")
	private String numeroconselho;
	
	@NotNull(message="CPF campo Obrigatorio !")
	private String cpfresponsavel;
	
	private Integer statusbaixa;

}