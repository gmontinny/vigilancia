package br.gov.mt.vigilancia.saude.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
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
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @SequenceGenerator(name = "mensagem_idmensagem_seq", sequenceName = "mensagem_idmensagem_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensagem_idmensagem_seq")
    private Integer id;

    private LocalDate dataMensagem;

    @NotBlank(message = "Remetente é um campo obrigatório!")
    private String de;

    @NotBlank(message = "Destinatário é um campo obrigatório!")
    private String para;

    private Integer status;

    @NotBlank(message = "Texto da mensagem é um campo obrigatório!")
    private String texto;

    @Column(name = "idusuario")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "idordemservico")
    @NotNull(message = "Ordem de Serviço é um campo obrigatório!")
    private OrdemServico ordemServico;
}
