package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestaodocumentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idgestaodocumento;
    private String assuntogestaodocumento;
    private String cpfentregador;
    private Integer numerodocumento;
    private String nomeentregador;
    private String solicitantegestaodocumento;
    private Integer tiposolicitacao;
    private Date datagestaodocumento;
    private Integer idusuario;
    private String numprocesso;
    private Integer status;
    private String textodocumento;
    private Integer idusuariodestino;
    private Integer statusenvio;
    private Time horagestaodocumento;
    private Integer notificacao;
    private String usuariosnotificacao;
}
