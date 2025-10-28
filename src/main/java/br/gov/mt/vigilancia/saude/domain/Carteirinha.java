package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the carteirinha database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Carteirinha.findAll", query="SELECT c FROM Carteirinha c")
public class Carteirinha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="carteirinha_idcarteirinha", sequenceName = "carteirinha_idcarteirinha_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="carteirinha_idcarteirinha")
	private Integer idcarteirinha;

	@Temporal(TemporalType.DATE)
	private Date datacadastro;

	@Temporal(TemporalType.DATE)
	private Date dataemissao;
	
	@Temporal(TemporalType.DATE)
	private Date datavalidade;

	@NotNull(message="Foto campo Obrigatorio !")
	private String imagemcarteirinha;

	@NotNull(message="Processo campo Obrigatorio")
	private String numprocesso;
	

	private Integer statusimpresso;

}