package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the geraprocesso database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geraprocesso.findAll", query="SELECT g FROM Geraprocesso g")
public class Geraprocesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geraprocesso_idprocesso", sequenceName = "geraprocesso_idprocesso_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geraprocesso_idprocesso")
	private Integer idprocesso;

	@Temporal(TemporalType.DATE)
	private Date dataprocesso;

	private Time horaprocesso;

	private Integer idusuario;

	private Integer statusprocesso;

}