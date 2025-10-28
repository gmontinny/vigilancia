package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarteirinhaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idcarteirinha;
    private Date datacadastro;
    private Date dataemissao;
    private Date datavalidade;
    private String imagemcarteirinha;
    private String numprocesso;
    private Integer statusimpresso;
}
