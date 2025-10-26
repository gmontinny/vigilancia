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
@Table(name = "produtocategoria")
public class ProdutoCategoria {

    @Id
    @SequenceGenerator(name = "produtocategoria_idprodutocategoria_seq", sequenceName = "produtocategoria_idprodutocategoria_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtocategoria_idprodutocategoria_seq")
    private Integer id;

    @NotBlank(message = "Nome da categoria do produto é um campo obrigatório!")
    private String nome;
}
