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

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resposta")
public class Resposta {

    @Id
    @SequenceGenerator(name = "resposta_idresposta_seq", sequenceName = "resposta_idresposta_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resposta_idresposta_seq")
    private Integer id;

    private LocalDateTime dataResposta;

    @ManyToOne
    @JoinColumn(name = "idforum")
    @NotNull(message = "Fórum é um campo obrigatório!")
    private Forum forum;

    private String textoResposta;
}
