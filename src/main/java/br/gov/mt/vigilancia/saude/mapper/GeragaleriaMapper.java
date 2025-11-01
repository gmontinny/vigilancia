package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geragaleria;
import br.gov.mt.vigilancia.saude.dto.GeragaleriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeragaleriaMapper {

    GeragaleriaMapper INSTANCE = Mappers.getMapper(GeragaleriaMapper.class);

    GeragaleriaDTO toDTO(Geragaleria geragaleria);
    Geragaleria toEntity(GeragaleriaDTO geragaleriaDTO);
}
