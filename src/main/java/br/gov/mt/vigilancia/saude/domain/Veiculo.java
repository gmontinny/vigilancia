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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @SequenceGenerator(name = "veiculo_idveiculo_seq", sequenceName = "veiculo_idveiculo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_idveiculo_seq")
    private Integer id;

    @NotBlank(message = "Chassi é um campo obrigatório!")
    @Size(min = 17, message = "Chassi deve ter no mínimo 17 caracteres!")
    private String chassi;

    @NotBlank(message = "Placa é um campo obrigatório!")
    private String placa;

    private String numeroProcesso;

    private String placaCaminhao;

    private String chassiCaminhao;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    @NotNull(message = "Categoria é um campo obrigatório!")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idestabelecimento")
    @NotNull(message = "Estabelecimento é um campo obrigatório!")
    private Estabelecimento estabelecimento;
}
