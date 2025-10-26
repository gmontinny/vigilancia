package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Bpa;
import br.gov.mt.vigilancia.saude.dto.BpaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BpaMapper {

    BpaMapper INSTANCE = Mappers.getMapper(BpaMapper.class);

    BpaDTO toDto(Bpa bpa);

    Bpa toEntity(BpaDTO bpaDTO);
}
