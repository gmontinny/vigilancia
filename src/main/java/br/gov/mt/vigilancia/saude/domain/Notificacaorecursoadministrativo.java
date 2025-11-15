package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import java.sql.Time;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacaorecursoadministrativo database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaorecursoadministrativo.findAll", query="SELECT n FROM Notificacaorecursoadministrativo n ORDER BY n.idrecursoadministrativo DESC")
public class Notificacaorecursoadministrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaorecursoadministrativo_idrecursoadministrativo", sequenceName = "notificacaorecursoadministrativo_idrecursoadministrativo_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaorecursoadministrativo_idrecursoadministrativo")
	private Integer idrecursoadministrativo;

	@Temporal(TemporalType.DATE)
	private Date datarecursoadministrativo;

	private Time horarecursoadministrativo;

	private String textorecursoadministrativo;
	
	private String coordenador;
	
	private String assinatura;

}