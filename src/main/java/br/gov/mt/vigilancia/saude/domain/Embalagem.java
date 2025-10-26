package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "embalagem", schema = "app")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Embalagem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idembalagem")
    private Integer idEmbalagem;

    @NotNull(message = "Descrição da Embalagem campo Obrigatorio !")
    @Column(name = "descricaoembalagem")
    private String descricaoEmbalagem;
}
