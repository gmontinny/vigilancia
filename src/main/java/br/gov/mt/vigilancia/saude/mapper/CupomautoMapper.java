package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Cupomauto;
import br.gov.mt.vigilancia.saude.dto.CupomautoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CupomautoMapper {

    CupomautoMapper INSTANCE = Mappers.getMapper(CupomautoMapper.class);

    CupomautoDTO toDto(Cupomauto cupomauto);

    Cupomauto toEntity(CupomautoDTO cupomautoDTO);
}
