package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the embalagem database table.
 * 
 */
@Entity
@Table(name = "embalagem", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Embalagem.findAll", query="SELECT e FROM Embalagem e")
public class Embalagem implements Serializable {
	private static final long serialVersionUID = 1L;

 @Id
	@SequenceGenerator(name="embalagem_idembalagem", sequenceName = "embalagem_idembalagem_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="embalagem_idembalagem")
	private Integer idembalagem;

	@NotNull(message="Descrição da Embalagem campo Obrigatorio !")
	private String descricaoembalagem;

}