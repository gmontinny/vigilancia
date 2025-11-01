package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Embalagem;
import br.gov.mt.vigilancia.saude.dto.EmbalagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmbalagemMapper {

    EmbalagemMapper INSTANCE = Mappers.getMapper(EmbalagemMapper.class);

    EmbalagemDTO toDTO(Embalagem embalagem);
    Embalagem toEntity(EmbalagemDTO embalagemDTO);
}
