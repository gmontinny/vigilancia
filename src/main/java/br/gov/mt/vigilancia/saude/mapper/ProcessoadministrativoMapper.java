package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Processoadministrativo;
import br.gov.mt.vigilancia.saude.dto.ProcessoadministrativoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProcessoadministrativoMapper {

    ProcessoadministrativoMapper INSTANCE = Mappers.getMapper(ProcessoadministrativoMapper.class);

    @Mapping(source = "processo.numeroProcesso", target = "numprocesso")
    ProcessoadministrativoDTO toDTO(Processoadministrativo processoadministrativo);

    @Mapping(source = "numprocesso", target = "processo.numeroProcesso")
    Processoadministrativo toEntity(ProcessoadministrativoDTO processoadministrativoDTO);
}
