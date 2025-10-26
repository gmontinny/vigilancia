package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "documento")
public class Documento {

    @Id
    @SequenceGenerator(name = "documento_iddocumento_seq", sequenceName = "documento_iddocumento_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_iddocumento_seq")
    private Integer id;

    @NotBlank(message = "Descrição do documento é um campo obrigatório!")
    private String descricao;

    @NotNull(message = "Restrição do documento é um campo obrigatório!")
    private Integer restricao;

    // Relacionamento com Docnecessario será adicionado posteriormente
    // @OneToMany(mappedBy = "documento")
    // private List<Docnecessario> docNecessarios;
}
