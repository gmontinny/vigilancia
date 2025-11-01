package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Farmaceutico;
import br.gov.mt.vigilancia.saude.dto.FarmaceuticoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FarmaceuticoMapper {

    FarmaceuticoMapper INSTANCE = Mappers.getMapper(FarmaceuticoMapper.class);

    @Mapping(source = "processo.numeroProcesso", target = "numprocesso")
    FarmaceuticoDTO toDTO(Farmaceutico farmaceutico);

    @Mapping(source = "numprocesso", target = "processo.numeroProcesso")
    Farmaceutico toEntity(FarmaceuticoDTO farmaceuticoDTO);
}
