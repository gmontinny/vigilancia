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

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reclamacao")
public class Reclamacao {

    @Id
    @SequenceGenerator(name = "reclamacao_idreclamacao_seq", sequenceName = "reclamacao_idreclamacao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reclamacao_idreclamacao_seq")
    private Integer id;

    private String bairroReclamado;

    private LocalDate dataReclamado;

    private String descricaoReclamado;

    private String enderecoReclamado;

    private String nomeReclamado;

    private String nomeReclamante;

    private String telefoneReclamacao;

    private String tipoAtendimento;

    private String tipoReclamado;

    private String pontoReferencia;

    private Integer anonimaReclamacao;

    private Integer tipoImovel;

    private LocalTime horaReclamacao;

    @ManyToOne
    @JoinColumn(name = "idordemservico")
    private OrdemServico ordemServico;

    @ManyToOne
    @JoinColumn(name = "idprodutocategoria")
    @NotNull(message="Produto Categoria é um campo obrigatório !")
    private ProdutoCategoria produtoCategoria;
}
