package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apreensao")
public class Apreensao {

    @Id
    @SequenceGenerator(name = "apreensao_idapreensao_seq", sequenceName = "apreensao_idapreensao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apreensao_idapreensao_seq")
    private Integer id;

    private Integer descarte;

    @NotBlank(message = "Marca é um campo obrigatório!")
    private String marca;

    private Integer numeroAuto;

    private Integer quantidade;

    @NotBlank(message = "Produto é um campo obrigatório!")
    private String produto;

    private String localDescarte;

    private LocalDate validade;

    private String lote;

    private String volume;

    private LocalDate dataFabricante;

    @ManyToOne
    @JoinColumn(name = "idunidademedida")
    private Unidademedida unidadeMedida;
}
