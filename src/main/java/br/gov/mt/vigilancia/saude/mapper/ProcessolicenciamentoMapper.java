package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Processolicenciamento;
import br.gov.mt.vigilancia.saude.dto.ProcessolicenciamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProcessolicenciamentoMapper {

    ProcessolicenciamentoMapper INSTANCE = Mappers.getMapper(ProcessolicenciamentoMapper.class);

    @Mapping(source = "licenciamento.idlicenciamento", target = "idlicenciamento")
    ProcessolicenciamentoDTO toDTO(Processolicenciamento processolicenciamento);

    @Mapping(source = "idlicenciamento", target = "licenciamento.idlicenciamento")
    Processolicenciamento toEntity(ProcessolicenciamentoDTO processolicenciamentoDTO);
}
