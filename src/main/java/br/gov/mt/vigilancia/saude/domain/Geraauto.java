package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "geraauto")
public class Geraauto {

    @Id
    @SequenceGenerator(name = "geraauto_idgeraauto_seq", sequenceName = "geraauto_idgeraauto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geraauto_idgeraauto_seq")
    private Integer id;

    private LocalDate dataGeraauto;

    private LocalTime horaGeraauto;

    private Integer idUsuario;

    private Integer status;

    private String numeroProcesso;

    private String tipoPenalidade;

    private String valor;

    private Integer grauInfracao;

    private Integer idTramitacao;
}
