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
 * The persistent class for the arquitetonicos database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="arquitetonicos")
@NamedQuery(name="Arquitetonico.findAll", query="SELECT a FROM Arquitetonico a")
public class Arquitetonico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="arquitetonicos_idarquitetonicos", sequenceName = "arquitetonicos_idarquitetonicos_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="arquitetonicos_idarquitetonicos")
	private Integer idarquitetonicos;


	@Temporal(TemporalType.DATE)
	private Date dataanalisearquitetonicos;
	
	@NotNull(message="Situação do projeto arquitetônico campo obrigatorio !")
	private Integer situacaoarquitetonicos;
	
	@NotNull(message="Numero Tramitação campo Obrigatorio !")
	private Integer numerotramitacao;
	
	
	private Integer analisearquitetonico;
	
	@NotNull(message="Texto campo obrigatorio !")
	private String textoarquitetonico;

}