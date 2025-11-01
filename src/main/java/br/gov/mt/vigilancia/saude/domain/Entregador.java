package br.gov.mt.vigilancia.saude.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the entregador database table.
 * 
 */
@Entity
@Table(name = "entregador", schema = "app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Entregador.findAll", query="SELECT e FROM Entregador e")
public class Entregador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entregador_identregador", sequenceName = "app.entregador_identregador_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="entregador_identregador")
	private Integer identregador;

	private String celentregador;
	
	@NotNull(message="CPF campo obrigatorio !")
	private String cpfentregador;

	private String emailentregador;
	
	@NotNull(message="Nome campo obrigatorio !")
	@Size(min=3, message="Digite pelo menos 3 caracteres !")
	private String nomeentregador;
	
	@NotNull(message="Processo campo obrigatorio !")
	private String numprocesso;
	
	private String imagementregador;

	private String telentregador;

}