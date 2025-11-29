package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the restricao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Restricao.findAll", query="SELECT r FROM Restricao r")
public class Restricao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="restricao_idrestricao", sequenceName = "restricao_idrestricao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="restricao_idrestricao")
	private Integer idrestricao;

	@Temporal(TemporalType.DATE)
	private Date datarestricao;
	
	@ManyToOne
	@JoinColumn(name="idestabelecimento")
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	private Integer statusrestricao;

	private String textorestricao;

}