package br.gov.mt.vigilancia.saude.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmbalagemDTO {
    private Integer idEmbalagem;

    @NotNull(message = "Descrição da Embalagem campo Obrigatorio !")
    private String descricaoEmbalagem;
}
