package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Arquitetonico;
import br.gov.mt.vigilancia.saude.dto.ArquitetonicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArquitetonicoMapper {

    ArquitetonicoMapper INSTANCE = Mappers.getMapper(ArquitetonicoMapper.class);

    ArquitetonicoDTO toDTO(Arquitetonico arquitetonico);
    Arquitetonico toEntity(ArquitetonicoDTO arquitetonicoDTO);
}
