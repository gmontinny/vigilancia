package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the geracategoriaservico database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geracategoriaservico.findAll", query=" SELECT g FROM Geracategoriaservico g ORDER BY g.idgeracategoriaservico DESC ")
public class Geracategoriaservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geracategoriaservico_idgeracategoriaservico", sequenceName = "geracategoriaservico_idgeracategoriaservico_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geracategoriaservico_idgeracategoriaservico")
	private Integer idgeracategoriaservico;

	@Temporal(TemporalType.DATE)
	private Date datacategoriaservico;

	private Integer idusuario;

	private Integer status;

}