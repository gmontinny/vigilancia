package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itenscolheita;
import br.gov.mt.vigilancia.saude.dto.ItenscolheitaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItenscolheitaMapper {

    ItenscolheitaMapper INSTANCE = Mappers.getMapper(ItenscolheitaMapper.class);

    @Mapping(source = "termocolheita.idtermocolheita", target = "idtermocolheita")
    ItenscolheitaDTO toDTO(Itenscolheita itenscolheita);

    @Mapping(source = "idtermocolheita", target = "termocolheita.idtermocolheita")
    Itenscolheita toEntity(ItenscolheitaDTO itenscolheitaDTO);
}
