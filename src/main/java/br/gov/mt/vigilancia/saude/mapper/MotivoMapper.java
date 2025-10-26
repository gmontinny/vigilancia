package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Motivo;
import br.gov.mt.vigilancia.saude.dto.MotivoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MotivoMapper {

    MotivoMapper INSTANCE = Mappers.getMapper(MotivoMapper.class);

    MotivoDTO toDto(Motivo motivo);

    Motivo toEntity(MotivoDTO motivoDTO);
}
