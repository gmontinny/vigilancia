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
@Table(name = "tipoempresa")
public class TipoEmpresa {

    @Id
    @SequenceGenerator(name = "tipoempresa_idtipoempresa_seq", sequenceName = "tipoempresa_idtipoempresa_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoempresa_idtipoempresa_seq")
    private Integer id;

    private String descricao;

    private String sigla;
}
