package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geratramite;
import br.gov.mt.vigilancia.saude.dto.GeratramiteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeratramiteMapper {

    GeratramiteMapper INSTANCE = Mappers.getMapper(GeratramiteMapper.class);

    GeratramiteDTO toDTO(Geratramite geratramite);
    Geratramite toEntity(GeratramiteDTO geratramiteDTO);
}
