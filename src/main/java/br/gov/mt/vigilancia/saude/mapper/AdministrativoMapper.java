package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Administrativo;
import br.gov.mt.vigilancia.saude.dto.AdministrativoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdministrativoMapper {

    AdministrativoMapper INSTANCE = Mappers.getMapper(AdministrativoMapper.class);

    AdministrativoDTO toDTO(Administrativo administrativo);
    Administrativo toEntity(AdministrativoDTO administrativoDTO);
}
