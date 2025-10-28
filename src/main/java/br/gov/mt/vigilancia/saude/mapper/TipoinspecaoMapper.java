package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Tipoinspecao;
import br.gov.mt.vigilancia.saude.dto.TipoinspecaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipoinspecaoMapper {

    TipoinspecaoMapper INSTANCE = Mappers.getMapper(TipoinspecaoMapper.class);

    TipoinspecaoDTO toDTO(Tipoinspecao tipoinspecao);
    Tipoinspecao toEntity(TipoinspecaoDTO tipoinspecaoDTO);
}
