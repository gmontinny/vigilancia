package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Outroresponsavel;
import br.gov.mt.vigilancia.saude.dto.OutroresponsavelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OutroresponsavelMapper {

    OutroresponsavelMapper INSTANCE = Mappers.getMapper(OutroresponsavelMapper.class);

    @Mapping(source = "conselho.id", target = "idconselho")
    OutroresponsavelDTO toDTO(Outroresponsavel outroresponsavel);

    @Mapping(source = "idconselho", target = "conselho.id")
    Outroresponsavel toEntity(OutroresponsavelDTO outroresponsavelDTO);
}
