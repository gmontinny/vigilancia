package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "processo")
public class Processo {

    @Id
    @NotBlank(message = "Número do processo é um campo obrigatório!")
    private String numeroProcesso;

    private LocalDate dataEntrada;

    private Integer status;

    private Integer resultado;

    private String observacao;

    private String enderecoArquitetonico;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idestabelecimento")
    @NotNull(message = "Estabelecimento é um campo obrigatório!")
    private Estabelecimento estabelecimento;

}
