package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Prodi;
import br.gov.mt.vigilancia.saude.dto.ProdiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdiMapper {

    ProdiMapper INSTANCE = Mappers.getMapper(ProdiMapper.class);

    ProdiDTO toDto(Prodi prodi);

    Prodi toEntity(ProdiDTO prodiDTO);
}
