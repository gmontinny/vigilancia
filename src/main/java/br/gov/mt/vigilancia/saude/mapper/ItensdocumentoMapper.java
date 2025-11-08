package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensdocumento;
import br.gov.mt.vigilancia.saude.dto.ItensdocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensdocumentoMapper {

    ItensdocumentoMapper INSTANCE = Mappers.getMapper(ItensdocumentoMapper.class);

    ItensdocumentoDTO toDTO(Itensdocumento itensdocumento);
    Itensdocumento toEntity(ItensdocumentoDTO itensdocumentoDTO);
}
