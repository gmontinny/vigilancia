package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensgaleria;
import br.gov.mt.vigilancia.saude.dto.ItensgaleriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensgaleriaMapper {

    ItensgaleriaMapper INSTANCE = Mappers.getMapper(ItensgaleriaMapper.class);

    ItensgaleriaDTO toDTO(Itensgaleria itensgaleria);
    Itensgaleria toEntity(ItensgaleriaDTO itensgaleriaDTO);
}
