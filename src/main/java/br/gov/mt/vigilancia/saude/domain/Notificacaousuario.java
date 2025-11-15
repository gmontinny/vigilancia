package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the notificacaousuario database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Notificacaousuario.findAll", query="SELECT n FROM Notificacaousuario n")
public class Notificacaousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="notificacaousuario_idnotificacaousuario", sequenceName = "notificacaousuario_idnotificacaousuario_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="notificacaousuario_idnotificacaousuario")
	private Integer idnotificacaousuario;

	private Integer idusuario;

	private Integer numerodocumento;

}