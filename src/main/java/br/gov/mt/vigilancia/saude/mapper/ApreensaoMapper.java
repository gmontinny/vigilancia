package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Apreensao;
import br.gov.mt.vigilancia.saude.dto.ApreensaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UnidademedidaMapper.class})
public interface ApreensaoMapper {

    ApreensaoMapper INSTANCE = Mappers.getMapper(ApreensaoMapper.class);

    @Mapping(source = "unidadeMedida.id", target = "idUnidadeMedida")
    ApreensaoDTO toDto(Apreensao apreensao);

    @Mapping(target = "unidadeMedida", ignore = true)
    Apreensao toEntity(ApreensaoDTO apreensaoDTO);
}
