package br.gov.mt.vigilancia.saude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocnecessarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer iddocnecessario;
    private Integer idagrupamento;
    private Integer iditenssolicitacao;
    private Integer iddocumento;
    private List<UploadnecessarioDTO> uploadnecessarios;
}
