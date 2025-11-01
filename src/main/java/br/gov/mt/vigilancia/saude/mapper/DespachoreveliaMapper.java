package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Despachorevelia;
import br.gov.mt.vigilancia.saude.dto.DespachoreveliaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DespachoreveliaMapper {

    DespachoreveliaMapper INSTANCE = Mappers.getMapper(DespachoreveliaMapper.class);

    DespachoreveliaDTO toDTO(Despachorevelia despachorevelia);
    Despachorevelia toEntity(DespachoreveliaDTO despachoreveliaDTO);
}
