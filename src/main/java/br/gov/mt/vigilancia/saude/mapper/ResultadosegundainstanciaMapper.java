package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Resultadosegundainstancia;
import br.gov.mt.vigilancia.saude.dto.ResultadosegundainstanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultadosegundainstanciaMapper {

    ResultadosegundainstanciaMapper INSTANCE = Mappers.getMapper(ResultadosegundainstanciaMapper.class);

    ResultadosegundainstanciaDTO toDTO(Resultadosegundainstancia resultadosegundainstancia);
    Resultadosegundainstancia toEntity(ResultadosegundainstanciaDTO resultadosegundainstanciaDTO);
}
