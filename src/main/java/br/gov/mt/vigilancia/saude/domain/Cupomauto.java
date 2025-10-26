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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cupomauto")
public class Cupomauto {

    @Id
    @SequenceGenerator(name = "cupomauto_idcupom_seq", sequenceName = "cupomauto_idcupom_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cupomauto_idcupom_seq")
    private Integer id;

    private String descConformidade;

    private String descPorte;

    private Integer numeroAuto;

    private String valorConformidade;

    private String valorGerado;

    private String valorPorte;

    private Integer numeroConformidade;

    private Integer percConformidade;

    private Integer percPorte;
}
