package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "acao")
public class Acao {

    @Id
    @SequenceGenerator(name = "acao_idacao_seq", sequenceName = "acao_idacao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acao_idacao_seq")
    private Integer id;

    @NotBlank(message = "Nome da ação é um campo obrigatório!")
    @Size(min = 5, message = "Nome da ação deve ter no mínimo 5 caracteres!")
    private String nome;
}
