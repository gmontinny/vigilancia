package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "fiscaladm", schema = "app")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fiscaladm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfiscaladm")
    private Integer idFiscaladm;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    @NotNull(message = "Usuario campo obrigatorio !")
    private Usuario usuario;

    @Column(name = "responsavelfiscal")
    private Integer responsavelFiscal;

    @Column(name = "statusfiscal")
    private Integer statusFiscal;

    @Column(name = "numerotramiteadm")
    private Integer numeroTramiteAdm;
}
