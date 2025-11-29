package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Termorevelia;
import br.gov.mt.vigilancia.saude.dto.TermoreveliaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TermoreveliaMapper {

    TermoreveliaMapper INSTANCE = Mappers.getMapper(TermoreveliaMapper.class);

    TermoreveliaDTO toDTO(Termorevelia termorevelia);
    Termorevelia toEntity(TermoreveliaDTO termoreveliaDTO);
}
