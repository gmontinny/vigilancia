package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Analiseprocesso;
import br.gov.mt.vigilancia.saude.dto.AnaliseprocessoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnaliseprocessoMapper {

    AnaliseprocessoMapper INSTANCE = Mappers.getMapper(AnaliseprocessoMapper.class);

    AnaliseprocessoDTO toDTO(Analiseprocesso analiseprocesso);
    Analiseprocesso toEntity(AnaliseprocessoDTO analiseprocessoDTO);
}
