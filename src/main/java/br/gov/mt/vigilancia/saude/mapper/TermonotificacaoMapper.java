package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Estabelecimento;
import br.gov.mt.vigilancia.saude.domain.Termonotificacao;
import br.gov.mt.vigilancia.saude.dto.TermonotificacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TermonotificacaoMapper {

    TermonotificacaoMapper INSTANCE = Mappers.getMapper(TermonotificacaoMapper.class);

    // Map nested entity id -> flat id in DTO
    @Mapping(source = "estabelecimento.id", target = "idestabelecimento")
    TermonotificacaoDTO toDTO(Termonotificacao termonotificacao);

    // Map flat id in DTO -> nested entity using helper
    @Mapping(source = "idestabelecimento", target = "estabelecimento")
    Termonotificacao toEntity(TermonotificacaoDTO termonotificacaoDTO);

    // Helper to instantiate Estabelecimento from id (DTO uses Long)
    default Estabelecimento mapEstabelecimento(Long id) {
        if (id == null) {
            return null;
        }
        Estabelecimento e = new Estabelecimento();
        e.setId(id.intValue());
        return e;
    }
}
