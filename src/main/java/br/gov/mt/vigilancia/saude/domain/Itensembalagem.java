package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the itensembalagem database table.
 * 
 */
@Entity
@Table(name = "itensembalagem", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Itensembalagem.findAll", query="SELECT i FROM Itensembalagem i")
public class Itensembalagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itensembalagem_iditensembalagem", sequenceName = "itensembalagem_iditensembalagem_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="itensembalagem_iditensembalagem")
	private Integer iditensembalagem;

	@ManyToOne
	@JoinColumn(name="idembalagem")
	private Embalagem embalagem;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;

	private Integer numeroprodi;
	
	private Integer numeroitensprodi;
	

}