package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministrativoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idadministrativo;
    private String assinaturacoordenadoria;
    private String assinaturadiretoria;
    private String coordenadoria;
    private String diretoria;
    private String urlqrcode;
    private Date dataadministrativo;
}
