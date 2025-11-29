package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Valorauto;
import br.gov.mt.vigilancia.saude.dto.ValorautoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ValorautoMapper {

    ValorautoMapper INSTANCE = Mappers.getMapper(ValorautoMapper.class);

    ValorautoDTO toDTO(Valorauto valorauto);
    Valorauto toEntity(ValorautoDTO valorautoDTO);
}
