package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the administrativo database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Administrativo.findAll", query="SELECT a FROM Administrativo a")
public class Administrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="administrativo_idadministrativo", sequenceName = "administrativo_idadministrativo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="administrativo_idadministrativo")
	private Integer idadministrativo;
	
	@NotNull(message="Assinatura do(a) Coordenador(a) é obrigatorio !")
	private String assinaturacoordenadoria;
	
	@NotNull(message="Assinatura do(a) Diretor(a) é obrigatorio !")
	private String assinaturadiretoria;
	
	@NotNull(message="Nome do(a) Coordenador(a) é obrigatorio !")
	private String coordenadoria;
	
	@NotNull(message="Nome do(a) Diretor(a) é obrigatorio !")
	private String diretoria;
	
	private String urlqrcode;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataadministrativo;

}