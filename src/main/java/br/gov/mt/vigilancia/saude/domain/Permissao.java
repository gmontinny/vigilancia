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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @SequenceGenerator(name = "permissao_idpermissao_seq", sequenceName = "permissao_idpermissao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_idpermissao_seq")
    private Integer id;

    private Integer deletePermissao;

    private Integer insertPermissao;

    private Integer selectPermissao;

    private Integer updatePermissao;

    @ManyToOne
    @JoinColumn(name = "idtabelas")
    private Tabela tabela;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    @NotNull(message = "Usuário é um campo obrigatório!")
    private Usuario usuario;
}
