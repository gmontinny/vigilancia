package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the temoaditivo database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Temoaditivo.findAll", query="SELECT t FROM Temoaditivo t")
public class Temoaditivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="temoaditivo_idtermoaditivo", sequenceName = "temoaditivo_idtermoaditivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="temoaditivo_idtermoaditivo")
	private Integer idtermoaditivo;

	@NotNull(message = "COORDENADOR campo Obrigatório !")
	private String coordenadorresponsavel;

	@NotNull(message = "IMAGEM campo Obrigatório !")
	private String imagemassinatura;

	@NotNull(message = "TEXTO campo Obrigatório !")
	private String textoaditivo;

}