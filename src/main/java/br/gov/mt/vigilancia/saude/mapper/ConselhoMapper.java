package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Conselho;
import br.gov.mt.vigilancia.saude.dto.ConselhoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConselhoMapper {

    ConselhoMapper INSTANCE = Mappers.getMapper(ConselhoMapper.class);

    ConselhoDTO toDto(Conselho conselho);

    Conselho toEntity(ConselhoDTO conselhoDTO);
}
