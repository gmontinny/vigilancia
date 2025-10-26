package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Galeria;
import br.gov.mt.vigilancia.saude.dto.GaleriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GaleriaMapper {

    GaleriaMapper INSTANCE = Mappers.getMapper(GaleriaMapper.class);

    GaleriaDTO toDto(Galeria galeria);

    Galeria toEntity(GaleriaDTO galeriaDTO);
}
