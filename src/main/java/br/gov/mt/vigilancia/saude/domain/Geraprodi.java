package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "geraprodi", schema = "app")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Geraprodi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgeraprodi")
    private Integer idGeraprodi;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataprodi")
    private Date dataProdi;

    @Column(name = "horaprodi")
    private Time horaProdi;

    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "statusprodi")
    private Integer statusProdi;
}
