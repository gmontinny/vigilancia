package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Resultadoprimeirainstancia;
import br.gov.mt.vigilancia.saude.dto.ResultadoprimeirainstanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultadoprimeirainstanciaMapper {

    ResultadoprimeirainstanciaMapper INSTANCE = Mappers.getMapper(ResultadoprimeirainstanciaMapper.class);

    ResultadoprimeirainstanciaDTO toDTO(Resultadoprimeirainstancia resultadoprimeirainstancia);
    Resultadoprimeirainstancia toEntity(ResultadoprimeirainstanciaDTO resultadoprimeirainstanciaDTO);
}
