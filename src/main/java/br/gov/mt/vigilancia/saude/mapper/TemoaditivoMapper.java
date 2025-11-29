package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Temoaditivo;
import br.gov.mt.vigilancia.saude.dto.TemoaditivoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TemoaditivoMapper {

    TemoaditivoMapper INSTANCE = Mappers.getMapper(TemoaditivoMapper.class);

    TemoaditivoDTO toDTO(Temoaditivo temoaditivo);
    Temoaditivo toEntity(TemoaditivoDTO temoaditivoDTO);
}
