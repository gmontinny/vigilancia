package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Despachoinstancia;
import br.gov.mt.vigilancia.saude.dto.DespachoinstanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DespachoinstanciaMapper {

    DespachoinstanciaMapper INSTANCE = Mappers.getMapper(DespachoinstanciaMapper.class);

    DespachoinstanciaDTO toDTO(Despachoinstancia despachoinstancia);
    Despachoinstancia toEntity(DespachoinstanciaDTO despachoinstanciaDTO);
}
