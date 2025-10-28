package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Despachocontrarazao;
import br.gov.mt.vigilancia.saude.dto.DespachocontrarazaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DespachocontrarazaoMapper {

    DespachocontrarazaoMapper INSTANCE = Mappers.getMapper(DespachocontrarazaoMapper.class);

    DespachocontrarazaoDTO toDTO(Despachocontrarazao despachocontrarazao);
    Despachocontrarazao toEntity(DespachocontrarazaoDTO despachocontrarazaoDTO);
}
