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
@Table(name = "forum")
public class Forum {

    @Id
    @SequenceGenerator(name = "forum_idforum_seq", sequenceName = "forum_idforum_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forum_idforum_seq")
    private Integer id;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "idordemservico")
    @NotNull(message = "Ordem de Serviço é um campo obrigatório!")
    private OrdemServico ordemServico;

    private String textoForum;

    private String textoUsuario;

    private Integer statusForum;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    @NotNull(message = "Usuário é um campo obrigatório!")
    private Usuario usuario;
}
