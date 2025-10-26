package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fiscal")
public class Fiscal {

    @Id
    @SequenceGenerator(name = "fiscal_idfiscal_seq", sequenceName = "fiscal_idfiscal_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fiscal_idfiscal_seq")
    private Integer id;

    @NotNull(message = "Status do fiscal é um campo obrigatório!")
    private Integer status;

    private Integer numeroTramitacao;

    private Integer responsavelFiscal;

    private Integer totalNotificacao;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    @NotNull(message = "Usuário é um campo obrigatório!")
    private Usuario usuario;
}
