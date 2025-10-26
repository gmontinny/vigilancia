package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Roteiro;
import br.gov.mt.vigilancia.saude.dto.RoteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoteiroMapper {

    RoteiroMapper INSTANCE = Mappers.getMapper(RoteiroMapper.class);

    RoteiroDTO toDto(Roteiro roteiro);

    Roteiro toEntity(RoteiroDTO roteiroDTO);
}
