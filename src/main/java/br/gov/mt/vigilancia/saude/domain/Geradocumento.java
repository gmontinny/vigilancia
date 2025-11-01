package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the geradocumento database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geradocumento.findAll", query="SELECT g FROM Geradocumento g")
public class Geradocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geradocumento_idgeradocumento", sequenceName = "geradocumento_idgeradocumento_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geradocumento_idgeradocumento")
	private Integer idgeradocumento;

	private Integer idusuario;

	private Integer status;

}