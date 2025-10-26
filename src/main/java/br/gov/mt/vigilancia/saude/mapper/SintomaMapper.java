package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Sintoma;
import br.gov.mt.vigilancia.saude.dto.SintomaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SintomaMapper {

    SintomaMapper INSTANCE = Mappers.getMapper(SintomaMapper.class);

    SintomaDTO toDto(Sintoma sintoma);

    Sintoma toEntity(SintomaDTO sintomaDTO);
}
