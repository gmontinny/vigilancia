package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "timeline")
public class Timeline {

    @Id
    @SequenceGenerator(name = "timeline_idtimeline_seq", sequenceName = "timeline_idtimeline_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeline_idtimeline_seq")
    private Integer id;

    private LocalDate dataTimeline;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    private Integer situacao;

    private String texto;

    private String numeroProcesso;

    private String tipoSituacao;

    private LocalTime horaTimeline;
}
