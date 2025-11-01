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
 * The persistent class for the geracodigocertificacao database table.
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Geracodigocertificacao.findAll", query="SELECT g FROM Geracodigocertificacao g")
public class Geracodigocertificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="geracodigocertificacao_idcodigocertificacao", sequenceName = "geracodigocertificacao_idcodigocertificacao_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="geracodigocertificacao_idcodigocertificacao")
	private Integer idcodigocertificacao;

	@Temporal(TemporalType.DATE)
	private Date datacertificacao;

	private Time horacertificacao;
	
	private String chavecertificacao;

}