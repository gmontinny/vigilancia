package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the arquivodocumentos database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="arquivodocumentos")
@NamedQuery(name="Arquivodocumento.findAll", query="SELECT a FROM Arquivodocumento a")
public class Arquivodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="arquivodocumentos_idarquivo", sequenceName = "arquivodocumentos_idarquivo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="arquivodocumentos_idarquivo")
	private Integer idarquivo;

	@Temporal(TemporalType.DATE)
	private Date dataarquivo;

	private Time horaarquivo;

	private String nomearquivo;
	
	private String tamanhoarquivo;
	
	private String usuarioarquivo;
	
	private String tipoarquivo;
	
	private String nomeoriginal;
	
	private Integer statusarquivo;
	
	private String textoarquivo;
	
	private String nomeeditado;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;

}