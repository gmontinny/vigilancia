package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prodi")
public class Prodi {

    @Id
    @SequenceGenerator(name = "prodi_idprodi_seq", sequenceName = "prodi_idprodi_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodi_idprodi_seq")
    private Integer id;

    @NotBlank(message = "CNPJ da Empresa é um campo obrigatório!")
    private String cnpjEmpresa;

    @NotBlank(message = "CNPJ do Fabricante é um campo obrigatório!")
    private String cnpjFabricante;

    private String numeroProcesso;

    private Integer numeroProdi;
}
