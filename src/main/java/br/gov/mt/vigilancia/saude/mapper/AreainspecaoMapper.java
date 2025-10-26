package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Areainspecao;
import br.gov.mt.vigilancia.saude.dto.AreainspecaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AreainspecaoMapper {

    AreainspecaoMapper INSTANCE = Mappers.getMapper(AreainspecaoMapper.class);

    AreainspecaoDTO toDTO(Areainspecao areainspecao);
    Areainspecao toEntity(AreainspecaoDTO areainspecaoDTO);
}
