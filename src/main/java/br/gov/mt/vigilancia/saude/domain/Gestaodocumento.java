package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the gestaodocumento database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Gestaodocumento.findAll", query="SELECT g FROM Gestaodocumento g WHERE g.status <> 5 ORDER BY g.idgestaodocumento DESC ")
public class Gestaodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="gestaodocumento_idgestaodocumento", sequenceName = "gestaodocumento_idgestaodocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="gestaodocumento_idgestaodocumento")
	private Integer idgestaodocumento;

	@NotNull(message="Assunto campo Obrigatorio !")
	private String assuntogestaodocumento;

	@NotNull(message="CPF campo Obrigatorio !")
	private String cpfentregador;

	private Integer numerodocumento;
	
	@NotNull(message="NOME entregador campo Obrigatorio !")
	private String nomeentregador;

	@NotNull(message="Solicitante campo Obrigatorio !")
	private String solicitantegestaodocumento;
	
	@NotNull(message="Tipo Solicitação campo Obrigatorio !")
	private Integer tiposolicitacao;
	
	@Temporal(TemporalType.DATE)
	private Date datagestaodocumento;	
	
	private Integer idusuario;
	private String numprocesso;
	private Integer status;
	private String textodocumento;
	
	private Integer idusuariodestino;
	
	private Integer statusenvio;
	
	private Time horagestaodocumento;
	
	private Integer notificacao;
	
	private String usuariosnotificacao;
	

}