package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geraroteiro;
import br.gov.mt.vigilancia.saude.dto.GeraroteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeraroteiroMapper {

    GeraroteiroMapper INSTANCE = Mappers.getMapper(GeraroteiroMapper.class);

    GeraroteiroDTO toDTO(Geraroteiro geraroteiro);
    Geraroteiro toEntity(GeraroteiroDTO geraroteiroDTO);
}
