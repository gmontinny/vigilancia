package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Licenciamento;
import br.gov.mt.vigilancia.saude.dto.LicenciamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LicenciamentoMapper {

    LicenciamentoMapper INSTANCE = Mappers.getMapper(LicenciamentoMapper.class);

    LicenciamentoDTO toDTO(Licenciamento licenciamento);
    Licenciamento toEntity(LicenciamentoDTO licenciamentoDTO);
}
