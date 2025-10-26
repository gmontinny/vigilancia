package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geraauto;
import br.gov.mt.vigilancia.saude.dto.GeraautoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeraautoMapper {

    GeraautoMapper INSTANCE = Mappers.getMapper(GeraautoMapper.class);

    GeraautoDTO toDto(Geraauto geraauto);

    Geraauto toEntity(GeraautoDTO geraautoDTO);
}
